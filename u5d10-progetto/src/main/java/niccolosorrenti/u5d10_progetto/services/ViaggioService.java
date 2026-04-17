package niccolosorrenti.u5d10_progetto.services;

import niccolosorrenti.u5d10_progetto.entities.StatoViaggio;
import niccolosorrenti.u5d10_progetto.entities.Viaggio;
import niccolosorrenti.u5d10_progetto.exceptions.NotFoundException;
import niccolosorrenti.u5d10_progetto.repositories.ViaggioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ViaggioService {

    private final ViaggioRepository viaggioRepository;

    public ViaggioService(ViaggioRepository viaggioRepository) {
        this.viaggioRepository = viaggioRepository;
    }

    public Viaggio createViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }

    public Viaggio getViaggioById(UUID id) {
        return viaggioRepository.findById(id).orElseThrow(() -> new NotFoundException("Viaggio non trovato"));
    }

    public Viaggio updateViaggio(UUID id, Viaggio viaggio) {
        Viaggio found = this.getViaggioById(id);

        found.setDestinazione(viaggio.getDestinazione());
        found.setData(viaggio.getData());
        found.setStato(viaggio.getStato());

        return viaggioRepository.save(found);
    }

    public void deleteViaggio(UUID id) {
        viaggioRepository.deleteById(id);
    }

    public Viaggio cambiaStatoViaggio(UUID id, StatoViaggio statoViaggio) {
        Viaggio viaggio = this.getViaggioById(id);
        viaggio.setStato(statoViaggio);
        return viaggioRepository.save(viaggio);
    }
}
