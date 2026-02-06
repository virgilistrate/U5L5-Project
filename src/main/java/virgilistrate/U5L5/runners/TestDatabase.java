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
        Edificio napoli = new Edificio("Sede Napoli", "Via Buonarotti 13", "Napoli");
        Edificio palermo = new Edificio("Sede Palermo", "Via Stretto 37", "Palermo");

        edificioRepository.save(napoli);
        edificioRepository.save(palermo);

        // POSTAZIONI
        Postazione p3 = new Postazione(
                0003,
                "Postazione privata 1",
                TipoPostazione.SALA_RIUNIONI,
                1,
                napoli
        );

        Postazione p4 = new Postazione(
                0004,
                "Open space 5 posti",
                TipoPostazione.OPENSPACE,
                5,
                palermo
        );

        postazioneRepository.save(p3);
        postazioneRepository.save(p4);

        // UTENTI
        Utente u3 = new Utente("Virgilist", "Virgil", "Istrate", "virgil@email.com");
        Utente u4 = new Utente("Marco", "Marco", "Califano", "marco@email.com");

        utenteRepository.save(u3);
        utenteRepository.save(u4);

        System.out.println(" DATI INSERITI CORRETTAMENTE ");
    }
}
