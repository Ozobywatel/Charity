package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Category;
import pl.coderslab.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}
