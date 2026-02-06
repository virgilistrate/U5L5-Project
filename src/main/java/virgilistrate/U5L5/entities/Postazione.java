package virgilistrate.U5L5.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "postazioni",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "codice_univoco")
        }
)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name = "codice_univoco", nullable = false)
    private long codiceUnivoco;

    @Column(nullable = false)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPostazione tipo;

    @Column(name = "n_posti", nullable = false)
    private int nPosti;

    @ManyToOne
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;

    public Postazione(long codiceUnivoco, String descrizione, TipoPostazione tipo, int nPosti, Edificio edificio) {
        this.codiceUnivoco = codiceUnivoco;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.nPosti = nPosti;
        this.edificio = edificio;
    }
}
