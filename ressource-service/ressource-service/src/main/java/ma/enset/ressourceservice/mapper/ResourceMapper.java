package ma.enset.ressourceservice.mapper;

import ma.enset.ressourceservice.dtos.ResourceDTO;
import ma.enset.ressourceservice.entities.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ResourceMapper {
    private ModelMapper mapper = new ModelMapper();
    public Resource from(ResourceDTO resourceDTO){
        return mapper.map(resourceDTO, Resource.class);
    }

    public ResourceDTO from(Resource resource){
        return mapper.map(resource, ResourceDTO.class);
    }
}
