package ma.enset.reservationservice.mapper;


import ma.enset.reservationservice.dtos.PersonneDTO;
import ma.enset.reservationservice.entities.Personne;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonneMapper {
    ModelMapper modelMapper = new ModelMapper();

    public Personne from(PersonneDTO personneDTO){
        return modelMapper.map(personneDTO, Personne.class);
    }

    public PersonneDTO from(Personne personne){
        return modelMapper.map(personne, PersonneDTO.class);
    }
}
