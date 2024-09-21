package com.example.lesson9.servlets;

import com.example.lesson9.entity.ValidAboutMe;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidAboutMeValidator implements ConstraintValidator<ValidAboutMe, String> {
    private int wordCount;

    @Override
    public void initialize(ValidAboutMe constraintAnnotation) {
        this.wordCount = constraintAnnotation.wordCount();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        if (s.isBlank()) {
            return false;
        }
        String[] words = s.split("\\W");
        return words.length >= wordCount;
    }
}
