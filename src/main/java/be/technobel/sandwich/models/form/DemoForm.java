package be.technobel.sandwich.models.form;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
public class DemoForm {

    @Positive
    @PositiveOrZero
    @Negative
    @NegativeOrZero
    @Min(0)
    @Max(10)
    @Digits(integer = 5, fraction = 2)
    private int entier;
    // pareil que int +
    @NotNull
    private Integer entierWrapper;

    @AssertTrue
    @AssertFalse
    private boolean aBoolean;

    @Null
    @NotNull
    private Object object;

    @Size(min = 1, max = 5)
    @NotEmpty
    private Collection<?> collection;

    @NotEmpty
    @NotBlank // not empty + not null
    @Size(min = 1, max = 5)
    @Pattern(regexp = "[a-z]+")
    @Email
    private String chaine;

    @Past
    @PastOrPresent
    @Future
    @FutureOrPresent
    private LocalDateTime date;

}
