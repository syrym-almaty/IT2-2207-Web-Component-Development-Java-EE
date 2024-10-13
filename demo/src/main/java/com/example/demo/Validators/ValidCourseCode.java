package com.example.demo.Validators;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CourseCodeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCourseCode {
    String message() default "Invalid course code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

public class CourseCodeValidator implements ConstraintValidator<ValidCourseCode, String> {
    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        // Implement validation logic
        return code.matches("^[A-Z]{4}\\d{4}$");
    }
}