package ma.enset.reservationservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String contexte;
    private Date date;
    private String duree;
    @ManyToOne
    private Personne personne;
}
