package niccolosorrenti.u5d10_progetto.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import niccolosorrenti.u5d10_progetto.entities.StatoViaggio;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ViaggioPayload {
    private String destinazione;
    private LocalDate data;
    private StatoViaggio stato;
}
