package es.edu.upc.hackaton.model;

import lombok.*;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Table
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Listing {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String fileURL;
    @Column
    private String owner;
    @Column
    private Double priceAmount;
    @Column
    private Currency priceCurrency;
    @Column
    private String title;
    @Column
    private Integer upvotes;
    @Column
    private Integer downvotes;
}
