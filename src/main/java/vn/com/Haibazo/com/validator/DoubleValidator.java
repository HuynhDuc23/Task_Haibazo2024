package vn.com.Haibazo.com.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = {ValidConstraint.class })
public @interface DoubleValidator {
    String message() default "Must be a valid double between 1 and 5";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
