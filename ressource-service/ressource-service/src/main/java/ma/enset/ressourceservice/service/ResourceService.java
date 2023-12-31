package ma.enset.ressourceservice.service;


import ma.enset.ressourceservice.dtos.ResourceDTO;

import java.util.List;

public interface ResourceService {
    ResourceDTO save(ResourceDTO resourceDTO);
    List<ResourceDTO> findAll();
    ResourceDTO findById(Long id);
    ResourceDTO update(Long id, ResourceDTO resourceDTO);
    void deleteById(Long id);

}
