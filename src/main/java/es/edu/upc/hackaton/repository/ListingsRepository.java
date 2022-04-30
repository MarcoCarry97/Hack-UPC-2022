package es.edu.upc.hackaton.repository;

import es.edu.upc.hackaton.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingsRepository extends JpaRepository<Listing, Long> {
}
