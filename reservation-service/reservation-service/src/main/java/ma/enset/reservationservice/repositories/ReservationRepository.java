package ma.enset.reservationservice.repositories;

import ma.enset.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
