package virgilistrate.U5L5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import virgilistrate.U5L5.entities.Postazione;
import virgilistrate.U5L5.entities.TipoPostazione;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);

    Optional<Postazione> findByCodiceUnivoco(long codiceUnivoco);
}
