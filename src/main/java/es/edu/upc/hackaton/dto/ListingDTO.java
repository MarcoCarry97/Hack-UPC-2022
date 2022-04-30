package es.edu.upc.hackaton.dto;

import lombok.*;

import java.util.Currency;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListingDTO {
    private Long id;
    private String fileURL;
    private String owner;
    private Double priceAmount;
    private Currency priceCurrency;
    private String title;
    private Integer upvotes;
    private Integer downvotes;
    private String scamCertainty;
}
