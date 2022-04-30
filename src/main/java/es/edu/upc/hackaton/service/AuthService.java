package es.edu.upc.hackaton.service;

import es.edu.upc.hackaton.model.Auth;
import es.edu.upc.hackaton.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public Optional<Auth> find(Auth auth) {
        return authRepository.findById(auth.getEmail()).filter(foundAuth -> foundAuth.getEncodedPassword().equals(auth.getEncodedPassword()));
    }

    public void save(Auth auth) {
        authRepository.save(auth);
    }

    public void saveAll(List<Auth> auths) {
        authRepository.saveAll(auths);
    }
}
