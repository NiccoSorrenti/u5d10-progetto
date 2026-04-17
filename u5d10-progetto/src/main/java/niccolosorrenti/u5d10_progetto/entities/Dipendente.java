package niccolosorrenti.u5d10_progetto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "dipendenti")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Dipendente {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @Column(name = "dipendente_id")
    private UUID dipendenteId;

    @Column(unique = true, nullable = false)
    private String username;

    private String nome;
    private String cognome;

    @Column(unique = true, nullable = false)
    private String email;

    private String imageUrl;

    public Dipendente(String username, String nome, String cognome, String email, String imageUrl) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.imageUrl = imageUrl;
    }
}
