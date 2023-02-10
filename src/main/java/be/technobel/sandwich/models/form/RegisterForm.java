package be.technobel.sandwich.models.form;

import be.technobel.sandwich.validation.constraints.EmailNotTaken;
import be.technobel.sandwich.validation.constraints.InPast;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
public class RegisterForm {

    @NotBlank
    @Email
    @EmailNotTaken
    private String email;
    @NotBlank
    @Size(min=4)
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    @InPast(amount = 1, unit = ChronoUnit.YEARS)
    private LocalDate birthdate;

}
