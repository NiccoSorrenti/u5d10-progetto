package niccolosorrenti.u5d10_progetto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "viaggi")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Viaggio {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @Column(name = "viaggio_id")
    private UUID viaggioId;

    private String destinazione;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatoViaggio stato;

    public Viaggio(String destinazione, LocalDate data, StatoViaggio stato) {
        this.destinazione = destinazione;
        this.data = data;
        this.stato = stato;
    }
}
