package ma.enset.reservationservice.mapper;

import ma.enset.reservationservice.dtos.ReservationDTO;
import ma.enset.reservationservice.entities.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapper {
    ModelMapper modelMapper = new ModelMapper();

    public Reservation from(ReservationDTO reservationDTO){
        return modelMapper.map(reservationDTO, Reservation.class);
    }

    public ReservationDTO from(Reservation reservation){
        return modelMapper.map(reservation, ReservationDTO.class);
    }
}
