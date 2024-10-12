package vn.com.Haibazo.com.validator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StringValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidString {
    String message() default "\n" +
            "This field must contain both letters and numbers and be at least 4 characters long";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
