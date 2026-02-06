package virgilistrate.U5L5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import virgilistrate.U5L5.entities.Postazione;
import virgilistrate.U5L5.entities.TipoPostazione;
import virgilistrate.U5L5.exceptions.NotFoundException;
import virgilistrate.U5L5.repositories.PostazioneRepository;

import java.util.List;

@Service
@Slf4j
public class PostazioneService {

    private final PostazioneRepository postazioneRepository;

    @Autowired
    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta) {

        List<Postazione> result = postazioneRepository
                .findByTipoAndEdificio_Citta(tipo, citta);

        if (result.isEmpty()) {
            throw new NotFoundException("Nessuna postazione trovata per tipo " + tipo + " nella città " + citta);
        }

        log.info("Trovate {} postazioni di tipo {} nella città {}", result.size(), tipo, citta);

        return result;
    }
}
