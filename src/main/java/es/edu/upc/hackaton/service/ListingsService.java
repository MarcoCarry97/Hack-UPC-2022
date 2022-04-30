package es.edu.upc.hackaton.service;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ListingsService {
    public byte[] loadFile(String filename) throws IOException {
        InputStream imageStream = getClass().getClassLoader().getResourceAsStream(filename);
        return IOUtils.toByteArray(imageStream);
    }
}
