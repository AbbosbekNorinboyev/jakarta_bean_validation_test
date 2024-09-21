package com.example.lesson9.entity;

import com.example.lesson9.servlets.ValidAboutMeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {ValidAboutMeValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAboutMe {
    String message() default "Word count must be greater than 0";
    int wordCount() default 5;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
