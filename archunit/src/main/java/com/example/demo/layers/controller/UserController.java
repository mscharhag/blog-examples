package com.example.demo.layers.controller;

import com.example.demo.layers.service.UserService;
import com.example.demo.model.User;


public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public User getUser() {
        return this.service.getUser();
    }

}
