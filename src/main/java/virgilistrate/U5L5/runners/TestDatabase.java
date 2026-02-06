package virgilistrate.U5L5.runners;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import virgilistrate.U5L5.entities.*;
import virgilistrate.U5L5.repositories.*;

@Component
@RequiredArgsConstructor
public class TestDatabase implements CommandLineRunner {

    private final EdificioRepository edificioRepository;
    private final PostazioneRepository postazioneRepository;
    private final UtenteRepository utenteRepository;

    @Override
    public void run(String... args) {

        System.out.println(" TEST DATABASE START ");

        // EDIFICI
        Edificio milano = new Edificio("Sede Milano", "Via Galvani 24", "Milano");
        Edificio roma = new Edificio("Sede Roma", "Viale dell'Arte 25", "Roma");

        edificioRepository.save(milano);
        edificioRepository.save(roma);

        // POSTAZIONI
        Postazione p1 = new Postazione(
                0001,
                "Postazione privata 1",
                TipoPostazione.PRIVATO,
                1,
                milano
        );

        Postazione p2 = new Postazione(
                0002,
                "Open space 5 posti",
                TipoPostazione.OPENSPACE,
                5,
                roma
        );

        postazioneRepository.save(p1);
        postazioneRepository.save(p2);

        // UTENTI
        Utente u1 = new Utente("giangiorgio", "Giovanni", "Giorgini", "Giovanni@email.com");
        Utente u2 = new Utente("AjejeBrazorf", "Aldo", "Baglio", "Aldo@email.com");

        utenteRepository.save(u1);
        utenteRepository.save(u2);

        System.out.println(" DATI INSERITI CORRETTAMENTE ");
    }
}
