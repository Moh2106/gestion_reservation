package ma.enset.reservationservice.service;

import jakarta.persistence.EntityNotFoundException;
import ma.enset.reservationservice.dtos.PersonneDTO;
import ma.enset.reservationservice.entities.Personne;
import ma.enset.reservationservice.mapper.PersonneMapper;
import ma.enset.reservationservice.repositories.PersonneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonneService implements Services<PersonneDTO>{
    private PersonneRepository personneRepository;
    private PersonneMapper personneMapper;

    public PersonneService(PersonneRepository personneRepository, PersonneMapper personneMapper) {
        this.personneRepository = personneRepository;
        this.personneMapper = personneMapper;
    }

    @Override
    public List<PersonneDTO> findAll() {
        return personneRepository.findAll().stream().map(personneMapper::from).collect(Collectors.toList());
    }

    @Override
    public PersonneDTO findById(Long id) {
        Personne personne = personneRepository.findById(id).get();
        return personneMapper.from(personne);
    }

    @Override
    public PersonneDTO save(PersonneDTO personneDTO) {
        Personne personne = personneMapper.from(personneDTO);
        Personne save = personneRepository.save(personne);
        return personneMapper.from(save);
    }

    @Override
    public PersonneDTO update(Long id, PersonneDTO personneDTO) {
        PersonneDTO byId = findById(id);

        if (byId == null){
            throw new EntityNotFoundException("Personne avec l'ID "+ id + " n'existe pas");
        }

        if(personneDTO.getNom() != null)  byId.setNom(personneDTO.getNom());
        if(personneDTO.getEmail() != null)  byId.setEmail(personneDTO.getEmail());
        if (personneDTO.getFonction() != null) byId.setFonction(personneDTO.getFonction());
        if (personneDTO.getReservations() != null) byId.setReservations(personneDTO.getReservations());

        Personne personne = personneRepository.save(personneMapper.from(byId));
        return personneMapper.from(personne);
    }

    @Override
    public void delete(Long id) {
        personneRepository.deleteById(id);
    }
}
