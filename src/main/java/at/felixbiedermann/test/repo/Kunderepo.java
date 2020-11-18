package at.felixbiedermann.test.repo;

import at.felixbiedermann.test.model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Kunderepo extends JpaRepository<Kunde, Long> {
}
