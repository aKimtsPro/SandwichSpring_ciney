package be.technobel.sandwich.models.form;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class SandwichUpdateForm {

    @NotNull
    @Size(min=4, max=20)
    private String name;
    @NotNull
    private String desc;
    @Positive(message = "doit être positif")
    @Digits(integer = 2, fraction = 2)
    private double price;

    private List<Long> ingredientsId;

}
