package es.edu.upc.hackaton.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Currency;

@Getter
@Builder
public class ListingDTO {
    private MultipartFile file;
    private String owner;
    private Double priceAmount;
    private Currency priceCurrency;
    private String title;
}
