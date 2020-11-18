package at.felixbiedermann.test.repo;


import at.felixbiedermann.test.model.Rechnung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rechnungrepo extends JpaRepository<Rechnung, Long> {
}
