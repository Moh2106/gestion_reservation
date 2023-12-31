package ma.enset.reservationservice.web;

import ma.enset.reservationservice.dtos.PersonneDTO;
import ma.enset.reservationservice.service.PersonneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonneController {
    private PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/personnes")
    public List<PersonneDTO> findAllPersonne(){
        return personneService.findAll();
    }

    @GetMapping("/personnes/{id}")
    public PersonneDTO findPersonneById(@PathVariable Long id){
        return personneService.findById(id);
    }

    @PostMapping("/personnes")
    public PersonneDTO savePersonne(@RequestBody PersonneDTO personneDTO){
        return personneService.save(personneDTO);
    }

    @PutMapping("/personnes/{id}")
    public PersonneDTO updatePersonne(@PathVariable Long id,@RequestBody PersonneDTO personneDTO){
        return personneService.update(id, personneDTO);
    }

    @DeleteMapping("/personnes/{id}")
    public void deletePersonne(@PathVariable Long id){
        personneService.delete(id);
    }
}
