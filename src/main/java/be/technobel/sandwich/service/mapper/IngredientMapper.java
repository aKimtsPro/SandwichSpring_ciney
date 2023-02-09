package be.technobel.sandwich.service.mapper;

import be.technobel.sandwich.models.dto.IngredientDTO;
import be.technobel.sandwich.models.entity.Ingredient;
import org.springframework.stereotype.Service;

@Service
public class IngredientMapper {

    public IngredientDTO toDto(Ingredient ingredient){
        if( ingredient == null )
            return null;

        return IngredientDTO.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .build();
    }

}
