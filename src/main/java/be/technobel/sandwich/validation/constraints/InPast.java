package be.technobel.sandwich.validation.constraints;

import be.technobel.sandwich.validation.validators.InPastValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.temporal.ChronoUnit;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InPastValidator.class)
public @interface InPast {

    long amount() default 0;
    ChronoUnit unit() default ChronoUnit.DAYS;

    String message() default "should be 0 days in the past";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
