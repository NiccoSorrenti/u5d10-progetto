package niccolosorrenti.u5d10_progetto.repositories;

import niccolosorrenti.u5d10_progetto.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DipendenteRepository extends JpaRepository<Dipendente, UUID> {
    boolean existsByEmail(String email);
}
