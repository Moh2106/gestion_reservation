package ma.enset.reservationservice.web;

import ma.enset.reservationservice.dtos.ReservationDTO;
import ma.enset.reservationservice.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<ReservationDTO> findAllReservation(){
        return reservationService.findAll();
    }

    @GetMapping("/reservations/{id}")
    public ReservationDTO findReservationById(@PathVariable Long id){
        return reservationService.findById(id);
    }

    @PostMapping("/reservations")
    public ReservationDTO saveReservation(@RequestBody ReservationDTO reservationDTO){
        return reservationService.save(reservationDTO);
    }

    @PutMapping("/reservations/{id}")
    public ReservationDTO updateReservation(@PathVariable Long id,@RequestBody ReservationDTO reservationDTO){
        return reservationService.update(id, reservationDTO);
    }

    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationService.delete(id);
    }
}
