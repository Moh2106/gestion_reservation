package ma.enset.ressourceservice.service;

import jakarta.persistence.EntityNotFoundException;
import ma.enset.ressourceservice.dtos.ResourceDTO;
import ma.enset.ressourceservice.entities.Resource;
import ma.enset.ressourceservice.mapper.ResourceMapper;
import ma.enset.ressourceservice.repositories.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceServiceImpl implements ResourceService{
    private ResourceRepository resourceRepository;
    private ResourceMapper resourceMapper;

    public ResourceServiceImpl(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public ResourceDTO save(ResourceDTO resourceDTO) {
        Resource resource = resourceMapper.from(resourceDTO);
        Resource save = resourceRepository.save(resource);
        return resourceMapper.from(save);
    }

    @Override
    public List<ResourceDTO> findAll() {
        return resourceRepository.findAll().stream().map(resourceMapper::from).collect(Collectors.toList());
    }

    @Override
    public ResourceDTO findById(Long id) {
        Resource resource = resourceRepository.findById(id).get();
        return resourceMapper.from(resource);
    }

    @Override
    public ResourceDTO update(Long id, ResourceDTO resourceDTO) {
        ResourceDTO byId = findById(id);

        if (byId == null){
            throw new EntityNotFoundException("Personne avec l'ID "+ id + " n'existe pas");
        }

        if(resourceDTO.getNom() != null)  byId.setNom(resourceDTO.getNom());
        if(resourceDTO.getType() != null)  byId.setType(resourceDTO.getType());

        Resource resource = resourceRepository.save(resourceMapper.from(resourceDTO));
        return resourceMapper.from(resource);
    }

    @Override
    public void deleteById(Long id) {
        resourceRepository.deleteById(id);
    }
}
