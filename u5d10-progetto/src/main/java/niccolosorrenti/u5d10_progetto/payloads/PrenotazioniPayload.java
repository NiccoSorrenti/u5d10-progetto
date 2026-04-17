package niccolosorrenti.u5d10_progetto.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PrenotazioniPayload {
    private Long dipendenteId;
    private Long viaggioId;
    private LocalDate dataRichiesta;
    private String note;
}
