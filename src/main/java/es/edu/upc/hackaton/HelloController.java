package es.edu.upc.hackaton;

import es.edu.upc.hackaton.model.Listing;
import es.edu.upc.hackaton.service.ListingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private ListingsService listingsService;

    @RequestMapping("/sso")
    public String sso() {
        return "sso";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
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
