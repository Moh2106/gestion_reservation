package ma.enset.reservationservice.dtos;

import lombok.*;
import ma.enset.reservationservice.entities.Reservation;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonneDTO {
    private String nom;
    private String email;
    private String fonction;
    private List<Reservation> reservations;
}
