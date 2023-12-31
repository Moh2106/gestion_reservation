package ma.enset.reservationservice.service;

import ma.enset.reservationservice.dtos.PersonneDTO;
import ma.enset.reservationservice.dtos.ReservationDTO;
import ma.enset.reservationservice.entities.Personne;
import ma.enset.reservationservice.entities.Reservation;
import ma.enset.reservationservice.mapper.ReservationMapper;
import ma.enset.reservationservice.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService implements Services<ReservationDTO>{
    private ReservationRepository reservationRepository;
    private ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public List<ReservationDTO> findAll() {
        return reservationRepository.findAll().stream().map(reservationMapper::from).collect(Collectors.toList());
    }

    @Override
    public ReservationDTO findById(Long id) {
        Reservation reservation = reservationRepository.findById(id).get();
        return reservationMapper.from(reservation);
    }

    @Override
    public ReservationDTO save(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.from(reservationDTO);
        Reservation save = reservationRepository.save(reservation);
        return reservationMapper.from(save);
    }

    @Override
    public ReservationDTO update(Long id, ReservationDTO reservationDTO) {
        ReservationDTO byId = findById(id);

        if(reservationDTO.getNom() != null)  byId.setNom(reservationDTO.getNom());
        if(reservationDTO.getContexte() != null)  byId.setContexte(reservationDTO.getContexte());
        if (reservationDTO.getDate() != null) byId.setDate(reservationDTO.getDate());
        if (reservationDTO.getDuree() != null) byId.setDuree(reservationDTO.getDuree());
        if (reservationDTO.getPersonne() != null) byId.setPersonne(reservationDTO.getPersonne());

        Reservation reservation = reservationMapper.from(byId);
        Reservation reservation1 = reservationRepository.save(reservation);
        return reservationMapper.from(reservation1);


    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}
