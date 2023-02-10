package be.technobel.sandwich.models.form;

import be.technobel.sandwich.validation.constraints.DemoGlobalConstraint;
import lombok.Data;

import java.time.LocalDate;

@Data
@DemoGlobalConstraint
public class DemoGlobalValidationForm {

    private LocalDate begin;
    private LocalDate end;

}
