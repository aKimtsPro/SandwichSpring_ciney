package be.technobel.sandwich.models.dto;

import be.technobel.sandwich.models.entity.Ingredient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientDTO {

    private Long id;
    private String name;

    public static IngredientDTO from(Ingredient entity){
        if( entity == null )
            return null;

        return IngredientDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}
