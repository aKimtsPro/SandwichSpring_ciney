package be.technobel.sandwich.models.form;

import lombok.Data;

@Data
public class SandwichUpdateForm {

    private String name;
    private String desc;
    private double price;

}
