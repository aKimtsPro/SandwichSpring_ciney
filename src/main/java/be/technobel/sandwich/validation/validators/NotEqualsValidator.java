package be.technobel.sandwich.validation.validators;

import be.technobel.sandwich.validation.constraints.NotEquals;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEqualsValidator implements ConstraintValidator<NotEquals, Number> {

    private double notEqualValue;

    @Override
    public void initialize(NotEquals constraintAnnotation) {
        notEqualValue = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        return value.doubleValue() != notEqualValue;
    }
}
