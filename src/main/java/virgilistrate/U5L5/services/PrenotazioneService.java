package virgilistrate.U5L5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import virgilistrate.U5L5.entities.Prenotazione;
import virgilistrate.U5L5.entities.Postazione;
import virgilistrate.U5L5.entities.Utente;
import virgilistrate.U5L5.exceptions.NotFoundException;
import virgilistrate.U5L5.exceptions.ValidationException;
import virgilistrate.U5L5.repositories.PrenotazioneRepository;
import virgilistrate.U5L5.repositories.PostazioneRepository;
import virgilistrate.U5L5.repositories.UtenteRepository;

import java.time.LocalDate;

@Service
@Slf4j
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;
    private final UtenteRepository utenteRepository;
    private final PostazioneRepository postazioneRepository;

    @Autowired
    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository,
                               UtenteRepository utenteRepository,
                               PostazioneRepository postazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.utenteRepository = utenteRepository;
        this.postazioneRepository = postazioneRepository;
    }

    public Prenotazione savePrenotazione(String username, long codicePostazione, LocalDate data) {

        //  Verifica utente
        Utente utente = utenteRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Utente " + username + " non trovato"));

        //  Verifica postazione
        Postazione postazione = postazioneRepository.findByCodiceUnivoco(codicePostazione)
                .orElseThrow(() -> new NotFoundException("Postazione con codice " + codicePostazione + " non trovata"));

        //  Controllo che la postazione non sia già prenotata
        if (prenotazioneRepository.existsByPostazione_IdAndData(postazione.getId(), data)) {
            throw new ValidationException("La postazione è già prenotata per la data " + data);
        }

        //  Controllo che l'utente non abbia già una prenotazione in quella data
        if (prenotazioneRepository.existsByUtente_IdAndData(utente.getId(), data)) {
            throw new ValidationException("L'utente ha già una prenotazione per la data " + data);
        }

        //  Creo la prenotazione
        Prenotazione prenotazione = new Prenotazione(data, postazione, utente);

        //  Salvo nel databese
        prenotazioneRepository.save(prenotazione);


        log.info("Prenotazione salvata correttamente per utente {} in data {}", username, data);

        return prenotazione;
    }
}
