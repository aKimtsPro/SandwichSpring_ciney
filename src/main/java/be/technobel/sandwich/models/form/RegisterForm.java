package be.technobel.sandwich.models.form;

import be.technobel.sandwich.validation.constraints.EmailNotTaken;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

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
    @Past
    private LocalDate birthdate;

}
