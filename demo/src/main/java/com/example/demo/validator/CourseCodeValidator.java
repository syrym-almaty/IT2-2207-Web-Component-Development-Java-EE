package com.example.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeValidator implements ConstraintValidator<ValidCourseCode, String> {
    @Override
    public boolean isValid(String courseCode, ConstraintValidatorContext context) {
        if (courseCode == null || courseCode.isEmpty()) {
            return false;
        }

        return courseCode.matches("^[A-Z]+-\\d+$");
    }
}