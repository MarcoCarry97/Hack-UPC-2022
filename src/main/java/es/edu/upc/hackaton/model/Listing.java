package es.edu.upc.hackaton.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Currency;

@Entity
@Table
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Listing {
    @Id
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
