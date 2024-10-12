package vn.com.Haibazo.com.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StringValidator implements ConstraintValidator<ValidString,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value==null){
            return true ; // use @Notnull
        }
        return value.length() >= 4 && value.matches("^(?=.*[a-zA-Z])(?=.*\\d).+$");
    }

    @Override
    public void initialize(ValidString constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
