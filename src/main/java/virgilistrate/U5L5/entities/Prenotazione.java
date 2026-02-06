package virgilistrate.U5L5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "prenotazioni",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"postazione_id", "data"}),
                @UniqueConstraint(columnNames = {"utente_id", "data"})
        }
)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "postazione_id", nullable = false)
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    public Prenotazione(LocalDate data, Postazione postazione, Utente utente) {
        this.data = data;
        this.postazione = postazione;
        this.utente = utente;
    }
}
