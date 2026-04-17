package niccolosorrenti.u5d10_progetto.controller;

import niccolosorrenti.u5d10_progetto.entities.Dipendente;
import niccolosorrenti.u5d10_progetto.payloads.DipendentePayload;
import niccolosorrenti.u5d10_progetto.services.DipendenteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

    private final DipendenteService dipendenteService;

    public DipendentiController(DipendenteService dipendenteService) {
        this.dipendenteService = dipendenteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente createDipendente(@RequestBody DipendentePayload payload) {
        Dipendente d = new Dipendente();
        d.setUsername(payload.getUsername());
        d.setNome(payload.getNome());
        d.setCognome(payload.getCognome());
        d.setEmail(payload.getEmail());

        return dipendenteService.creaDipendente(d);
    }

    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.getAllDipendenti();
    }

    @GetMapping("/{id}")
    public Dipendente getDipendenteById(@PathVariable UUID id) {
        return dipendenteService.getDipendenteById(id);
    }

    @PutMapping("/{id}")
    public Dipendente updateDipendente(@PathVariable UUID id, @RequestBody DipendentePayload payload) {
        Dipendente d = new Dipendente();
        d.setUsername(payload.getUsername());
        d.setNome(payload.getNome());
        d.setCognome(payload.getCognome());
        d.setEmail(payload.getEmail());

        return dipendenteService.updateDipendente(id, d);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDipendente(@PathVariable UUID id) {
        dipendenteService.deleteDipendente(id);
    }


}
