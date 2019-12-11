package com.mscharhag.methodvalidation;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Service
@Validated
public class UserService {

    public User getUser(@NotBlank String uuid) {
        return new User("John");
    }

    public void createUser(@Valid User user) {
        System.out.println("Creating user");
    }
}
