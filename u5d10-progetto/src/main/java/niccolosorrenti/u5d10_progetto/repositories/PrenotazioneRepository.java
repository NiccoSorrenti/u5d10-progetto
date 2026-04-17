package niccolosorrenti.u5d10_progetto.repositories;

import niccolosorrenti.u5d10_progetto.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
    boolean existsByDipendenteIdAndDataRichiesta(UUID dipendenteId, LocalDate dataRichiesta);
}
