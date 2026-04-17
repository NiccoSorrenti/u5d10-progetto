package niccolosorrenti.u5d10_progetto.repositories;

import niccolosorrenti.u5d10_progetto.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ViaggioRepository extends JpaRepository<Viaggio, UUID> {
}
