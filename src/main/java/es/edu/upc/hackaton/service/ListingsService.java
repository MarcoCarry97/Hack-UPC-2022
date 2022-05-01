package es.edu.upc.hackaton.service;

import es.edu.upc.hackaton.dto.ListingDTO;
import es.edu.upc.hackaton.model.Listing;
import es.edu.upc.hackaton.repository.ListingsRepository;
import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
                        {
                            try {
                                return ListingDTO.builder()
                                        .id(listing.getId())
                                        .fileURL(listing.getFileURL())
                                        .title(listing.getTitle())
                                        .owner(listing.getOwner())
                                        .priceAmount(listing.getPriceAmount())
                                        .priceCurrency(listing.getPriceCurrency())
                                        .upvotes(listing.getUpvotes())
                                        .downvotes(listing.getDownvotes())
                                        .scamCertainty(calculateScamCertainty(listing.getUpvotes(), listing.getDownvotes(), listing.getFileURL()))
                                        .build();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                .collect(Collectors.toList());
    }

    public void upvote(Long id) {
        Listing listing = listingsRepository.findById(id).orElseThrow();
        listing.setUpvotes(listing.getUpvotes() + 1);
        saveListing(listing);
    }

    public void downvote(Long id){
        Listing listing = listingsRepository.findById(id).orElseThrow();
        listing.setDownvotes(listing.getDownvotes() + 1);
        saveListing(listing);
    }
    private String calculateScamCertainty(Integer upvotes, Integer downvotes, String fileURL) throws IOException {
        if (upvotes == null || downvotes == null) {
            return "0%";
        }
        String URL="https://api-us.restb.ai/vision/v2/multipredict";
        URL+="?model_id=re_condition";
        URL+="&image_url="+fileURL+"?raw=true";
        URL+="&client_key=f54dd2143572f2c8fdb88896b8b84695782cea5f5c41ca2b119e49232d29554a";

        String [] command = {"curl", URL};

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.directory(new File(System.getProperty("user.home")));

        try {
            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader (new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();

            System.out.println ("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ((double) upvotes / (upvotes + downvotes)) * 100 + "%";
    }
}
