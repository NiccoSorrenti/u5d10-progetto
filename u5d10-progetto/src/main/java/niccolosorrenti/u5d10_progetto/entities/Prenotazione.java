package niccolosorrenti.u5d10_progetto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prenotazioni", uniqueConstraints = @UniqueConstraint(columnNames = {"dipendente_id", "dataRichiesta"}))
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Prenotazione {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @Column(name = "prenotazione_id")
    private UUID prenotazioneId;

    private LocalDate dataRichiesta;

    @ManyToOne
    @JoinColumn(name = "dipendente_id", nullable = false)
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(name = "viaggio_id", nullable = false)
    private Viaggio viaggio;

    private String note;

    public Prenotazione(LocalDate dataRichiesta, Dipendente dipendente, Viaggio viaggio, String note) {
        this.dataRichiesta = dataRichiesta;
        this.dipendente = dipendente;
        this.viaggio = viaggio;
        this.note = note;
    }
}
