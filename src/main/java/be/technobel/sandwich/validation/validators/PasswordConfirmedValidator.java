package be.technobel.sandwich.validation.validators;

import be.technobel.sandwich.models.form.RegisterForm;
import be.technobel.sandwich.validation.constraints.PasswordConfirmed;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConfirmedValidator implements ConstraintValidator<PasswordConfirmed, RegisterForm> {
    @Override
    public boolean isValid(RegisterForm value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getConfirm());
    }
}
