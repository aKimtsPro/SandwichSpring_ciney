package be.technobel.sandwich.validation.validators;

import be.technobel.sandwich.service.UserService;
import be.technobel.sandwich.validation.constraints.EmailNotTaken;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class EmailNotTakenValidator implements ConstraintValidator<EmailNotTaken, String> {

    private final UserService userService;

    public EmailNotTakenValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userService.checkEmailNotTaken( email );
    }
}
