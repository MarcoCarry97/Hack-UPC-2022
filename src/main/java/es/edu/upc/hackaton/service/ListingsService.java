package es.edu.upc.hackaton.service;

import es.edu.upc.hackaton.dto.ListingDTO;
import es.edu.upc.hackaton.dto.RealEstateDTO;
import es.edu.upc.hackaton.model.Listing;
import es.edu.upc.hackaton.repository.ListingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Currency;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

@Component
public class ListingsService {

    @Autowired
    private ListingsRepository listingsRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final BiPredicate<String, String> lowercaseContainsText = (str, text) -> (str.toLowerCase().contains(text));

    public void saveListing(Listing listing) {
        listingsRepository.save(listing);
    }

    public List<ListingDTO> findAll() {
        return listingsRepository.findAll()
                .stream()
                .map(listing -> {
                            String realEstateAPIUrl = getRealEstateAPIUrl(listing.getFileURL());
                            RealEstateDTO realEstateDTO = new RealEstateDTO();
                            try {
                                realEstateDTO = restTemplate.getForObject(realEstateAPIUrl, RealEstateDTO.class);
                            } catch (HttpClientErrorException.TooManyRequests e) {
                                realEstateDTO.setScore(0.0);
                                System.err.println("Too many requests! Got null score, defaulting to 0.0");
                            }

                            return ListingDTO.builder()
                                    .id(listing.getId())
                                    .fileURL(listing.getFileURL())
                                    .title(listing.getTitle())
                                    .owner(listing.getOwner())
                                    .priceAmount(listing.getPriceAmount())
                                    .priceCurrency(Currency.getInstance(listing.getPriceCurrency()))
                                    .upvotes(listing.getUpvotes())
                                    .downvotes(listing.getDownvotes())
                                    .scamCertainty(calculateScamCertainty(listing, realEstateDTO.getScore()))
                                    .build();
                        }
                )
                .collect(Collectors.toList());
    }

    private String getRealEstateAPIUrl(String fileURL) {
        return "https://api-us.restb.ai/vision/v2/multipredict?model_id=re_condition&image_url=" + fileURL + "?raw=true&client_key=f54dd2143572f2c8fdb88896b8b84695782cea5f5c41ca2b119e49232d29554a";
    }

    public List<ListingDTO> searchByText(String text) {
        return findAll().stream().filter(listingDTO -> lowercaseContainsText.test(listingDTO.getOwner(), text) ||
                        lowercaseContainsText.test(listingDTO.getPriceAmount().toString(), text) ||
                        lowercaseContainsText.test(listingDTO.getPriceCurrency().toString(), text) ||
                        lowercaseContainsText.test(listingDTO.getTitle(), text))
                .collect(Collectors.toList());
    }

    public void upvote(Long id) {
        Listing listing = listingsRepository.findById(id).orElseThrow();
        listing.setUpvotes(listing.getUpvotes() + 1);
        saveListing(listing);
    }

    public void downvote(Long id) {
        Listing listing = listingsRepository.findById(id).orElseThrow();
        listing.setDownvotes(listing.getDownvotes() + 1);
        saveListing(listing);
    }

    private String calculateScamCertainty(Listing listing, Double score) {
        if (listing.getDownvotes() == null) {
            return "0%";
        }
        return ((double) listing.getUpvotes() / (listing.getUpvotes() + listing.getDownvotes()) + score / listing.getPriceAmount()) * 100 + "%";
    }
}
