package com.example.demo.layers.repository;

import com.example.demo.model.User;

import javax.persistence.EntityManager;

public class UserRepository {

    private EntityManager entityManager;

    public User loadUser() {
        return new User("John Doe");
    }
}
