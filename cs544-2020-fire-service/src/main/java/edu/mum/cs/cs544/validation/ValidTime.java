package edu.mum.cs.cs544.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = TimeslotValidator.class)
@Documented
public @interface ValidTime {

    String message() default "End time is nust after begin time";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}