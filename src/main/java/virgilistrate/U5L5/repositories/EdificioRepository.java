package virgilistrate.U5L5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import virgilistrate.U5L5.entities.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}
