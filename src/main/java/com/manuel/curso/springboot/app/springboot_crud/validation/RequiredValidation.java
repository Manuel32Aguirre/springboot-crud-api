package com.manuel.curso.springboot.app.springboot_crud.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidation implements ConstraintValidator<IsRequired, String>{    

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value != null && !value.isEmpty() && !value.isBlank()){
            return true;
        }
        return false;
    }
}
