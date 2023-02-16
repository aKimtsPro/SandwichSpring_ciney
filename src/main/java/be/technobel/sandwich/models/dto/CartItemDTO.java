package be.technobel.sandwich.models.dto;

import be.technobel.sandwich.models.entity.CartItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * A DTO for the {@link be.technobel.sandwich.models.entity.CartItem} entity
 */
public record CartItemDTO(int qtt, SandwichDTO product) implements Serializable {

    public static CartItemDTO from(CartItem entity){
        if( entity == null )
            return null;

        return new CartItemDTO( entity.getQtt(), SandwichDTO.from(entity.getProduct()) );
    }

}