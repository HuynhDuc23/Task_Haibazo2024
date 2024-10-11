package vn.com.Haibazo.com.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.com.Haibazo.com.exception.CustomException;

public class ValidConstraint implements ConstraintValidator<DoubleValidator,Double> {

    @Override
    public void initialize(DoubleValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if (value == null) {
            context.disableDefaultConstraintViolation(); // Tắt thông báo lỗi mặc định
            context.buildConstraintViolationWithTemplate("Rating must not be null.") // Thêm thông báo lỗi cho trường hợp null
                    .addConstraintViolation();
            return false; // Trả về false nếu giá trị là null
        }

        // Kiểm tra xem giá trị có trong khoảng 1 đến 5 không
        if (value < 1 || value > 5) {
            context.disableDefaultConstraintViolation(); // Tắt thông báo lỗi mặc định
            context.buildConstraintViolationWithTemplate("Input must be a valid double between 1 and 5.") // Thêm thông báo lỗi tùy chỉnh
                    .addConstraintViolation();
            return false; // Trả về false khi không hợp lệ
        }

        return true; // Trả về true khi hợp lệ
    }
}
