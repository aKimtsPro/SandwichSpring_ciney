package be.technobel.sandwich.models.form;

import be.technobel.sandwich.validation.constraints.NotEquals;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class SandwichInsertForm {

    @Size(min=4)
    private String name;
    private String desc;
    @NotEquals(value = 2, message = "should not be 2")
    private double price;

    @Size(min = 2)
    private List<Long> ingredientsId;

}
