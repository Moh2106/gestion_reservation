package ma.enset.ressourceservice.repositories;

import ma.enset.ressourceservice.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
