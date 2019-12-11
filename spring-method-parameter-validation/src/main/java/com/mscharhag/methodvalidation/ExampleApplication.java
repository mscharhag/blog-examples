package com.mscharhag.methodvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class ExampleApplication {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ExampleApplication.class);
        UserService userService = context.getBean(UserService.class);

        userService.getUser("123");

        // the following to lines will fail the validation and raise a ConstraintViolationException
        // userService.getUser("");
        // userService.getUser(null);


        userService.createUser(new User("John"));

        // the following to lines will fail the validation and raise a ConstraintViolationException
        // userService.createUser(new User(""));
        // userService.createUser(new User(null));
    }
}
