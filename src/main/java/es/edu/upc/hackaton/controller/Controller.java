package es.edu.upc.hackaton.controller;

import es.edu.upc.hackaton.dto.AuthDTO;
import es.edu.upc.hackaton.dto.ListingDTO;
import es.edu.upc.hackaton.model.Auth;
import es.edu.upc.hackaton.service.AuthService;
import es.edu.upc.hackaton.service.ListingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ListingsService listingsService;
    @Autowired
    private AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity authenticate(@RequestBody AuthDTO authDTO) {
        Auth auth = Auth.builder().email(authDTO.getEmail())
                .firstName(authDTO.getFirstName())
                .lastName(authDTO.getLastName())
                .encodedPassword(authDTO.getEncodedPassword())
                .build();

        if (authService.find(auth).isPresent()) {
            return ResponseEntity.ok("Authenticated");
        }

        return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/listings")
    @ResponseBody
    public List<ListingDTO> getListings() {
        return listingsService.findAll();
    }

    @GetMapping("/upvote/{id}")
    public void upvote(@PathVariable String id) {
        listingsService.upvote(Long.parseLong(id));
    }

    @GetMapping("/downvote/{id}")
    public void downvote(@PathVariable String id) {
        listingsService.downvote(Long.parseLong(id));
    }
}
