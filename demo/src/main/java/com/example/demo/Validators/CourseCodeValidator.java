package com.example.demo.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeValidator implements ConstraintValidator<ValidCourseCode, String> {
    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        // Implement validation logic
        return code != null && code.matches("^[A-Z]{4}\\d{4}$"); // Example: A valid code must be 4 uppercase letters followed by 4 digits
    }
}