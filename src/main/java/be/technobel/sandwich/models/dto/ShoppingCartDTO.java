package be.technobel.sandwich.models.dto;

import be.technobel.sandwich.models.entity.CartItem;
import be.technobel.sandwich.models.entity.ShoppingCart;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
public class ShoppingCartDTO {

    private String ownerEmail;
    private Set<CartItemDTO> items;
    private double total;

    public static ShoppingCartDTO from(ShoppingCart entity){
        if( entity == null )
            return null;

        double total = 0;
        Set<CartItemDTO> items = new LinkedHashSet<>();
        for (CartItem item : entity.getItems()) {
            items.add( CartItemDTO.from(item) );
            total += item.getQtt() * item.getProduct().getPrice();
        }

        return ShoppingCartDTO.builder()
                .ownerEmail(entity.getOwner().getEmail())
                .total(total)
                .items(items)
                .build();
    }

}
