package be.technobel.sandwich.validation.constraints;

import be.technobel.sandwich.validation.validators.DemoGlobalValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DemoGlobalValidator.class)
public @interface DemoGlobalConstraint {

    String message() default "begin should be before end";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
