package es.edu.upc.hackaton.service;

import es.edu.upc.hackaton.dto.ListingDTO;
import es.edu.upc.hackaton.model.Listing;
import es.edu.upc.hackaton.repository.ListingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListingsService {

    @Autowired
    private ListingsRepository listingsRepository;

    public void saveListing(Listing listing) {
        listingsRepository.save(listing);
    }

    public List<ListingDTO> findAll() {
        return listingsRepository.findAll()
                .stream()
                .map(listing ->
                        ListingDTO.builder()
                                .id(listing.getId())
                                .fileURL(listing.getFileURL())
                                .title(listing.getTitle())
                                .owner(listing.getOwner())
                                .priceAmount(listing.getPriceAmount())
                                .priceCurrency(listing.getPriceCurrency())
                                .upvotes(listing.getUpvotes())
                                .downvotes(listing.getDownvotes())
                                .scamCertainty(calculateScamCertainty(listing.getUpvotes(), listing.getDownvotes()))
                                .build()
                )
                .collect(Collectors.toList());
    }

    public void upvote(Long id) {
        Listing listing = listingsRepository.findById(id).orElseThrow();
        listing.setUpvotes(listing.getUpvotes() + 1);
        saveListing(listing);
    }

    private String calculateScamCertainty(Integer upvotes, Integer downvotes) {
        if (upvotes == null || downvotes == null) {
            return "0%";
        }
        return ((double) upvotes / (upvotes + downvotes)) * 100 + "%";
    }
}
