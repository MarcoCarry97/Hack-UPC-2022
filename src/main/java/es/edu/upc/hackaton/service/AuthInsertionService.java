package es.edu.upc.hackaton.service;

import es.edu.upc.hackaton.model.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthInsertionService {
    @Autowired
    private AuthService authService;

    //    @PostMapping("/add-auth")
    @EventListener(ApplicationReadyEvent.class)
    public void insertAuthentication() {

        List<Auth> auths = new ArrayList<>();

        Auth auth = Auth.builder().email("moni.dziedzic@gmail.com")
                .firstName("Monika")
                .lastName("Dziedzic")
                .encodedPassword("abcd1234") // todo: encode / hash
                .build();
        auths.add(auth);

        Auth auth1 = Auth.builder().email("ala.ma.kota@gmail.com")
                .firstName("Ala")
                .lastName("MaKota")
                .encodedPassword("abcd2345") // todo: encode / hash
                .build();
        auths.add(auth1);

        authService.saveAll(auths);
    }
}
