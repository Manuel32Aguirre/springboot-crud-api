package com.manuel.curso.springboot.app.springboot_crud.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.manuel.curso.springboot.app.springboot_crud.services.ProductService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsExistsDbValidation implements ConstraintValidator<IsExistsDb, String>{

    @Autowired
    private ProductService productService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(productService == null) {
            return true;
        }
        if(value != null && !productService.existsBySku(value)){
            return true;
        }
        return false;
    }
    
}
