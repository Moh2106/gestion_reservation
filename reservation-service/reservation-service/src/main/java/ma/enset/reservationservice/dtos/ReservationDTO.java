package ma.enset.reservationservice.dtos;

import lombok.*;
import ma.enset.reservationservice.entities.Personne;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReservationDTO {
    private String nom;
    private String contexte;
    private Date date;
    private String duree;
    private Personne personne;
}
