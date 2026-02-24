package com.manuel.curso.springboot.app.springboot_crud;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
import org.springframework.web.context.WebApplicationContext;

import jakarta.validation.Validator;

@Configuration
@PropertySource("classpath:messages.properties")
public class AppConfig {
    
    @Bean
    public Validator validator(MessageSource messageSource, WebApplicationContext applicationContext) {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);
        factory.setConstraintValidatorFactory(new SpringConstraintValidatorFactory(applicationContext.getAutowireCapableBeanFactory()));
        return factory;
    }
}
