package be.technobel.sandwich.models.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SandwichInsertForm {

    private String name;
    private String desc;
    private double price;

}
