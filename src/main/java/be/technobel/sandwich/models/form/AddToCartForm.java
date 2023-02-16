package be.technobel.sandwich.models.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddToCartForm {

    @NotNull
    private Long productId;
    @Positive
    private int qtt;

}
