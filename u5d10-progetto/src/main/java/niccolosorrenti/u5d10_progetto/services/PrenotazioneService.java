package niccolosorrenti.u5d10_progetto.services;

import niccolosorrenti.u5d10_progetto.entities.Dipendente;
import niccolosorrenti.u5d10_progetto.entities.Prenotazione;
import niccolosorrenti.u5d10_progetto.entities.Viaggio;
import niccolosorrenti.u5d10_progetto.exceptions.ConflictException;
import niccolosorrenti.u5d10_progetto.exceptions.NotFoundException;
import niccolosorrenti.u5d10_progetto.repositories.DipendenteRepository;
import niccolosorrenti.u5d10_progetto.repositories.PrenotazioneRepository;
import niccolosorrenti.u5d10_progetto.repositories.ViaggioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;
    private final DipendenteRepository dipendenteRepository;
    private final ViaggioRepository viaggioRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, DipendenteRepository dipendenteRepository, ViaggioRepository viaggioRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
        this.dipendenteRepository = dipendenteRepository;
        this.viaggioRepository = viaggioRepository;
    }

    public Prenotazione createPrenotazione(UUID dipendenteId, UUID viaggioId, LocalDate data, String note) {
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId).orElseThrow(() -> new NotFoundException("Dipendente non trovato"));

        Viaggio viaggio = viaggioRepository.findById(viaggioId).orElseThrow(() -> new NotFoundException("Viaggio non trovato"));

        boolean dipendenteOccupato = prenotazioneRepository.existsByDipendenteIdAndDataRichiesta(dipendenteId, data);

        if (dipendenteOccupato) {
            throw new ConflictException("Dipendente gia occupato in questa data");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setDataRichiesta(data);
        prenotazione.setNote(note);

        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione getPrenotazioneById(UUID id) {
        return prenotazioneRepository.findById(id).orElseThrow(() -> new NotFoundException("Prenotazione non trovata"));
    }

    public void deletePrenotazione(UUID id) {
        prenotazioneRepository.deleteById(id);
    }
}
