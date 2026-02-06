
// ALLA FINE TestDatabase L HO USATO PER MANDARARE AL DATABASE TUTTI I DATI, MODIFICANDO NOMI, CITTA ECC.

package virgilistrate.U5L5.runners;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import virgilistrate.U5L5.entities.*;
import virgilistrate.U5L5.repositories.*;

// @Component
@RequiredArgsConstructor
public class TestDatabase implements CommandLineRunner {

    private final EdificioRepository edificioRepository;
    private final PostazioneRepository postazioneRepository;
    private final UtenteRepository utenteRepository;

    @Override
    public void run(String... args) {

        System.out.println(" TEST DATABASE START ");

        // EDIFICI
        Edificio venezia = new Edificio("Sede Venezia", "Via Napoli 54", "Venezia");
        Edificio bari = new Edificio("Sede Baria", "Via Nobel 73", "Bari");

        edificioRepository.save(venezia);
        edificioRepository.save(bari);

        // POSTAZIONI
        Postazione p5 = new Postazione(
                0005,
                "Postazione riunioni 9",
                TipoPostazione.SALA_RIUNIONI,
                9,
                venezia
        );

        Postazione p6 = new Postazione(
                0006,
                "Open space 7 posti",
                TipoPostazione.OPENSPACE,
                7,
                bari
        );

        postazioneRepository.save(p5);
        postazioneRepository.save(p6);

        // UTENTI
        Utente u5 = new Utente("Giuliz", "Giulia", "Bianchi", "giulia@email.com");
        Utente u6 = new Utente("Mariaro", "Maria", "Rosa", "maria@email.com");

        utenteRepository.save(u5);
        utenteRepository.save(u6);

        System.out.println(" DATI INSERITI CORRETTAMENTE ");
    }
}
