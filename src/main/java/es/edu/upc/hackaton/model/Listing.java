package es.edu.upc.hackaton.model;

import lombok.*;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Table
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Indexed
public class Listing {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String fileURL;
    @Column
    @Field(termVector = TermVector.YES)
    private String owner;
    @Column
    @Field(termVector = TermVector.YES)
    private Double priceAmount;
    @Column
    @Field(termVector = TermVector.YES)
    private String priceCurrency;
    @Column
    @Field(termVector = TermVector.YES)
    private String title;
    @Column
    private Integer upvotes;
    @Column
    private Integer downvotes;
}
