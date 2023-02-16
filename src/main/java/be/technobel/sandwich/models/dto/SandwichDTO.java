package be.technobel.sandwich.models.dto;

import be.technobel.sandwich.models.entity.Sandwich;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class SandwichDTO {

    private Long id;
    private String name;
    private String desc;
    private double price;

    private Set<IngredientDTO> ingredients;

    public static SandwichDTO from(Sandwich entity){
        if( entity == null )
            return null;

        return SandwichDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .desc(entity.getDescription())
                .price(entity.getPrice())
                .ingredients(
                        entity.getIngredients().stream()
                                .map(IngredientDTO::from)
                                .collect(Collectors.toSet())
                )
                .build();
    }

}
