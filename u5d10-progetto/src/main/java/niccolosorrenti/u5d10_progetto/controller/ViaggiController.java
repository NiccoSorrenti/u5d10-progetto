package niccolosorrenti.u5d10_progetto.controller;

import niccolosorrenti.u5d10_progetto.entities.StatoViaggio;
import niccolosorrenti.u5d10_progetto.entities.Viaggio;
import niccolosorrenti.u5d10_progetto.payloads.ViaggioPayload;
import niccolosorrenti.u5d10_progetto.services.ViaggioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/viaggi")
public class ViaggiController {

    private final ViaggioService viaggioService;

    public ViaggiController(ViaggioService viaggioService) {
        this.viaggioService = viaggioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio createViaggio(@RequestBody ViaggioPayload payload) {
        Viaggio v = new Viaggio();
        v.setDestinazione(payload.getDestinazione());
        v.setData(payload.getData());
        v.setStato(payload.getStato() != null ? payload.getStato() : StatoViaggio.IN_PROGRAMMA);

        return viaggioService.createViaggio(v);
    }

    @GetMapping
    public List<Viaggio> getAllViaggi() {
        return viaggioService.getAllViaggi();
    }

    @GetMapping("/{id}")
    public Viaggio getViaggioById(@PathVariable UUID id) {
        return viaggioService.getViaggioById(id);
    }

    @PutMapping("/{id}")
    public Viaggio updateViaggio(@PathVariable UUID id, @RequestBody ViaggioPayload payload) {

        Viaggio v = new Viaggio();
        v.setDestinazione(payload.getDestinazione());
        v.setData(payload.getData());
        v.setStato(payload.getStato());

        return viaggioService.updateViaggio(id, v);
    }

    @PutMapping("/{id}/stato")
    public Viaggio cambiaStatoViaggio(@PathVariable UUID id, @RequestParam StatoViaggio stato) {
        return viaggioService.cambiaStatoViaggio(id, stato);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteViaggio(@PathVariable UUID id) {
        viaggioService.deleteViaggio(id);
    }
}
