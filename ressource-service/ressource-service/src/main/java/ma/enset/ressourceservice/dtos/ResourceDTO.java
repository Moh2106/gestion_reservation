package ma.enset.ressourceservice.dtos;

import lombok.*;
import ma.enset.ressourceservice.enumeration.ResourceType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResourceDTO {
    private String nom;
    private ResourceType type;
}
