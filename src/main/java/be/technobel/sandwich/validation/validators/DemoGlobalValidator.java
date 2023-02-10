package be.technobel.sandwich.validation.validators;

import be.technobel.sandwich.models.form.DemoGlobalValidationForm;
import be.technobel.sandwich.validation.constraints.DemoGlobalConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DemoGlobalValidator implements ConstraintValidator<DemoGlobalConstraint, DemoGlobalValidationForm> {
    @Override
    public boolean isValid(DemoGlobalValidationForm value, ConstraintValidatorContext context) {
        return value.getBegin().isBefore( value.getEnd() );
    }
}
