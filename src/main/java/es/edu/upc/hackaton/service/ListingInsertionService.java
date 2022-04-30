package es.edu.upc.hackaton.service;

import es.edu.upc.hackaton.model.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Component
public class ListingInsertionService {
    @Autowired
    private ListingsService listingsService;

    @EventListener(ApplicationReadyEvent.class)
    public void saveListings() {
        List<Listing> listings = new ArrayList<>();
        listings.add(Listing.builder()
                .fileURL("https://media.timeout.com/images/105737732/750/422/image.jpg")
                .owner("Monika Dziedzic")
                .title("Well-communicated property close to Plaza de Catalunya")
                .priceAmount(500.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(86)
                .downvotes(14)
                //TODO: more data from Nitish
                .build());

        listings.forEach(listing -> listingsService.saveListing(listing));
    }
}
