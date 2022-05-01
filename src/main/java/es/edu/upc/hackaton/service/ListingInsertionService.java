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
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/115_bedroom.jpg")
                .owner("Monika Dziedzic")
                .title("Well-communicated property close to Plaza de Catalunya")
                .priceAmount(500.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(86)
                .downvotes(14)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/100_bedroom.jpg")
                .owner("Ping Pong")
                .title("Bright room close to the city centre")
                .priceAmount(360.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(78)
                .downvotes(2)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/101_kitchen.jpg")
                .owner("Rafael Jamal")
                .title("exterior room with everything close, near Joanic metro")
                .priceAmount(420.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(13)
                .downvotes(15)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/102_bedroom.jpg")
                .owner("Abdullah")
                .title("room in calle de Calabria")
                .priceAmount(300.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(80)
                .downvotes(6)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/103_bathroom.jpg")
                .owner("Tamara")
                .title("cozy room in esplugues de llobregat")
                .priceAmount(350.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(5)
                .downvotes(20)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/104_frontal.jpg")
                .owner("Mario Torres")
                .title("Room only for girls/female students")
                .priceAmount(250.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(112)
                .downvotes(20)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/105_bedroom.jpg")
                .owner("Marco Belluchi")
                .title("Room in an International Apartment near Plaza españa ")
                .priceAmount(650.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(5)
                .downvotes(50)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/106_bedroom.jpg")
                .owner("Monika Dziedzic")
                .title("Well-communicated property close to Plaza de Catalunya")
                .priceAmount(350.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(99)
                .downvotes(2)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/107_kitchen.jpg")
                .owner("Tamara")
                .title("Room for students for long term in Calle Mallorca")
                .priceAmount(425.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(112)
                .downvotes(25)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/108_frontal.jpg")
                .owner("Pablo Vizcano")
                .title("Independent house in Manresa")
                .priceAmount(1100.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(5)
                .downvotes(13)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/109_bathroom.jpg")
                .owner("Angel")
                .title("interior room with window for workers only")
                .priceAmount(600.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(50)
                .downvotes(40)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/110_frontal.jpg")
                .owner("Tamara")
                .title("entire flat for rent for working professionals only")
                .priceAmount(2000.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(14)
                .downvotes(14)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/111_kitchen.jpg")
                .owner("Sergio Garcia")
                .title("room for rent only in July")
                .priceAmount(400.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(50)
                .downvotes(19)
                .build());

        listings.add(Listing.builder()
                .fileURL("https://github.com/emanhamed/Houses-dataset/blob/master/Houses%20Dataset/112_bedroom.jpg")
                .owner("Maria Antonio")
                .title("Bright apartment near Plaza Catalunya")
                .priceAmount(2500.0)
                .priceCurrency(Currency.getInstance("EUR"))
                .upvotes(156)
                .downvotes(206)
                .build());

        listings.forEach(listing -> listingsService.saveListing(listing));
    }
}
