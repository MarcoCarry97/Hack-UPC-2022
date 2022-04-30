package es.edu.upc.hackaton.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Currency;

@Getter
@Builder
public class Listing {
    private MultipartFile file;
    private String owner;
    private Double priceAmount;
    private Currency priceCurrency;
    private String title;
}
