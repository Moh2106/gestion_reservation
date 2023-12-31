package ma.enset.reservationservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Personne {
    @Id
    private Long id;
    private String nom;
    private String email;
    private String fonction;
    @OneToMany
    private List<Reservation> reservations;
}
