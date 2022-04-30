package es.edu.upc.hackaton.service;

import es.edu.upc.hackaton.model.Auth;
import es.edu.upc.hackaton.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public List<Auth> findAll() {
        return authRepository.findAll();
    }

    public void save(Auth auth) {
        authRepository.save(auth);
    }

//    public boolean authenticate(AuthDTO authDTO) {
//        return TODO
//    }
}
