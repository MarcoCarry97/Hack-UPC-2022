package es.edu.upc.hackaton;

import es.edu.upc.hackaton.dto.AuthDTO;
import es.edu.upc.hackaton.dto.ListingDTO;
import es.edu.upc.hackaton.model.Auth;
import es.edu.upc.hackaton.service.AuthService;
import es.edu.upc.hackaton.service.ListingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private ListingsService listingsService;
    @Autowired
    private AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity authenticate(@RequestBody AuthDTO authDTO) {
        System.out.println(authDTO);

//        TODO: connect to db
        return ResponseEntity.ok("Authenticated");
    }

    @PostMapping("/add-auth")
    public ResponseEntity insertAuthentication(@RequestBody AuthDTO authDTO) {
        System.out.println(authDTO);
        Auth auth = Auth.builder().email(authDTO.getEmail())
                .firstName(authDTO.getFirstName())
                .lastName(authDTO.getLastName())
                .encodedPassword(authDTO.getEncodedPassword())
                .build();
        authService.save(auth);

        return ResponseEntity.ok("Inserted");
    }

    @GetMapping(value = "/listings")
    @ResponseBody
    public ResponseEntity<List<ListingDTO>> getListings() throws IOException {
        List<ListingDTO> listingDTOS = new ArrayList<>();

        String fileName = "lasagradafamilia.jpg";

        listingDTOS.add(ListingDTO.builder().file(new MockMultipartFile("file", fileName, MediaType.TEXT_HTML_VALUE, listingsService.loadFile(fileName))).title("La Sagrada Familia").owner("Gaudi").priceAmount(500.0).build());

        return ResponseEntity.ok().body(listingDTOS);
    }
}
