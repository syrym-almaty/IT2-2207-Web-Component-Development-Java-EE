package com.example.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeValidator implements ConstraintValidator<ValidCourseCode, String> {
    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        // Implement validation logic
        return code.matches("^[A-Z]{4}\\d{4}$");
    }
}