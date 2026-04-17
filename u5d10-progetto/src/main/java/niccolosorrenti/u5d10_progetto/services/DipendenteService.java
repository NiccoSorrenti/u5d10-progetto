package niccolosorrenti.u5d10_progetto.services;

import niccolosorrenti.u5d10_progetto.entities.Dipendente;
import niccolosorrenti.u5d10_progetto.exceptions.NotFoundException;
import niccolosorrenti.u5d10_progetto.repositories.DipendenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DipendenteService {

    private final DipendenteRepository dipendenteRepository;

    public DipendenteService(DipendenteRepository dipendenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
    }

    public Dipendente creaDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Dipendente getDipendenteById(UUID id) {
        return dipendenteRepository.findById(id).orElseThrow(() -> new NotFoundException("Dipendente non trovato"));
    }

    public Dipendente updateDipendente(UUID id, Dipendente dipendente) {
        Dipendente found = this.getDipendenteById(id);

        found.setUsername(dipendente.getUsername());
        found.setNome(dipendente.getNome());
        found.setCognome(dipendente.getCognome());
        found.setEmail(dipendente.getEmail());

        return dipendenteRepository.save(found);
    }

    public void deleteDipendente(UUID id) {
        dipendenteRepository.deleteById(id);
    }


}
