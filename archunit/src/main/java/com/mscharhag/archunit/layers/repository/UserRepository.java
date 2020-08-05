package com.mscharhag.archunit.layers.repository;

import com.mscharhag.archunit.model.User;

import javax.persistence.EntityManager;

public class UserRepository {

    private EntityManager entityManager;

    public User loadUser() {
        return new User("John Doe");
    }
}
