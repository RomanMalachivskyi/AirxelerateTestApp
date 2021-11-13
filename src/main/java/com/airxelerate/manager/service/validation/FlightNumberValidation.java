package com.airxelerate.manager.service.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FlightNumberValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FlightNumberValidation {
    String message() default "Invalid flight number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
