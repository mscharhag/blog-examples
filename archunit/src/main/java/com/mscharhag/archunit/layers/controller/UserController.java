package com.mscharhag.archunit.layers.controller;

import com.mscharhag.archunit.layers.service.UserService;
import com.mscharhag.archunit.model.User;


public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public User getUser() {
        return this.service.getUser();
    }

}
