package virgilistrate.U5L5.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import virgilistrate.U5L5.exceptions.NotFoundException;
import virgilistrate.U5L5.exceptions.ValidationException;
import virgilistrate.U5L5.services.PrenotazioneService;

import java.time.LocalDate;

@Component
@Slf4j
public class TestRunner implements CommandLineRunner {



    private final PrenotazioneService prenotazioneService;

    public TestRunner(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }


    // TEST PER VEDERE SE FUNZIONA CORRETTAMENTE
//    @Override
//    public void run(String... args) throws Exception {
//
//        LocalDate oggi = LocalDate.now();
//
//        try {
//
//            log.info(" TEST PRENOTAZIONE START ");
//
//            // 1) Prenotazione
//            prenotazioneService.savePrenotazione("Giuliz", 5, oggi);
//            log.info(" prenotazione effettuata correttamente.");
//
//            // 2) Tentativo di prenotare due prenotazioni per la stessa data
//            prenotazioneService.savePrenotazione("Giuliz", 5, oggi);
//            log.info("Seconda prenotazione effettuata.");
//
//        } catch (NotFoundException ex) {
//            log.error("NOT FOUND: " + ex.getMessage());
//        } catch (ValidationException ex) {
//            log.error("VALIDATION ERROR: " + ex.getMessage());
//        } catch (Exception ex) {
//            log.error("ERRORE GENERICO: " + ex.getMessage());
//        }
//
//        log.info(" TEST PRENOTAZIONE END ");
//    }
//

    //  AGGIUNGO 2 PRENOTAZIONE E PRENOTAZIONI OCCUPATE

    @Override
    public void run(String... args) throws Exception {

        LocalDate oggi = LocalDate.now();

        log.info("=== TEST PRENOTAZIONI START ===");

        try {

            // Prenotazione
            prenotazioneService.savePrenotazione("giangiorgio", 1, oggi);
            log.info("Prenotazione  effettuata correttamente.");

            // Tentativo di prenotare due prenotazioni per la stessa data
            prenotazioneService.savePrenotazione("giangiorgio", 1, oggi);
            log.info("Seconda prenotazione effettuata.");

        } catch (ValidationException ex) {
            log.error("VALIDATION ERROR: {}", ex.getMessage());
        } catch (NotFoundException ex) {
            log.error("NOT FOUND: {}", ex.getMessage());
        }

        try {

            //  Prenotazione
            prenotazioneService.savePrenotazione("AjejeBrazorf", 2, oggi.plusDays(1));
            log.info("Prenotazione  effettuata correttamente.");

            //  Tentativo di prenotare due prenotazioni per la stessa data
            prenotazioneService.savePrenotazione("AjejeBrazorf", 2, oggi.plusDays(1));
            log.info("seconda prenotazione effettuata correttamente.");

        } catch (ValidationException ex) {
            log.error("VALIDATION ERROR: {}", ex.getMessage());
        } catch (NotFoundException ex) {
            log.error("NOT FOUND: {}", ex.getMessage());
        }

        log.info("=== TEST PRENOTAZIONI END ===");
    }
}
