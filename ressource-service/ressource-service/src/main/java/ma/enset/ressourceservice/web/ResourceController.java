package ma.enset.ressourceservice.web;

import ma.enset.ressourceservice.dtos.ResourceDTO;
import ma.enset.ressourceservice.service.ResourceServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController {
    private ResourceServiceImpl resourceService;

    public ResourceController(ResourceServiceImpl resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/resources")
    public List<ResourceDTO> allResources(){
        return resourceService.findAll();
    }

    @GetMapping("/resources/{id}")
    public ResourceDTO resourcebyId(@PathVariable Long id){
        return resourceService.findById(id);
    }

    @PostMapping("/resources")
    public ResourceDTO saveResourceDTO(@RequestBody ResourceDTO resourceDTO){
        return resourceService.save(resourceDTO);
    }

    @PutMapping("/resources/{id}")
    public ResourceDTO updateResourceDTO(@PathVariable Long id, @RequestBody ResourceDTO resourceDTO){
        return resourceService.update(id, resourceDTO);
    }

    @DeleteMapping("/resources/{id}")
    public void deleteResourceDTO(@PathVariable Long id){
        resourceService.deleteById(id);
    }
}
