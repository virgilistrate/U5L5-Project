package virgilistrate.U5L5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import virgilistrate.U5L5.entities.Prenotazione;

import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean existsByPostazione_IdAndData(long postazioneId, LocalDate data);

    boolean existsByUtente_IdAndData(long utenteId, LocalDate data);
}
