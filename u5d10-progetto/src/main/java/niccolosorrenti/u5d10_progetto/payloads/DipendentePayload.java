package niccolosorrenti.u5d10_progetto.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DipendentePayload {
    private String username;
    private String nome;
    private String cognome;
    private String email;
}
