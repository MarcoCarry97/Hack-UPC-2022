package es.edu.upc.hackaton;

import es.edu.upc.hackaton.model.Listing;
import es.edu.upc.hackaton.service.ListingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private ListingsService listingsService;

    @GetMapping("/")
    public String index() {
        return "<meta name=\"google-signin-client_id\" content=\"62730202944-lmjv5pqrd0u8qqkng3ksreq6mpa7325r.apps.googleusercontent.com\">" +
                "<div class=\"g-signin2\" data-onsuccess=\"onSignIn\"></div>" +
                "<script src=\"https://apis.google.com/js/platform.js\" async defer></script>";
    }

    @GetMapping(value = "/listings")
    @ResponseBody
    public ResponseEntity<List<Listing>> getListings() throws IOException {
        List<Listing> listings = new ArrayList<>();

        String fileName = "lasagradafamilia.jpg";

        listings.add(Listing.builder().file(new MockMultipartFile("file", fileName, MediaType.TEXT_HTML_VALUE, listingsService.loadFile(fileName))).title("La Sagrada Familia").owner("Gaudi").priceAmount(500.0).build());

        return ResponseEntity.ok().body(listings);
    }
}
