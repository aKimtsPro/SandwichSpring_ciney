package be.technobel.sandwich.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter @Setter
public class CartItem extends BaseEntity<CartItem.Id> {

    @EmbeddedId
    private Id id;

    @MapsId("cartId")
    @ManyToOne
    private ShoppingCart cart;

    @MapsId("productId")
    @ManyToOne
    private Sandwich product;

    @Column(name = "product_qtt", nullable = false)
    private int qtt = 1;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "cart_id")
        private Long cartId;
        @Column(name = "product_id")
        private Long productId;

    }

}
