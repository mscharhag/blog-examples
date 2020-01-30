package com.example.demo.layers.service.impl;

import com.example.demo.layers.repository.UserRepository;
import com.example.demo.layers.service.UserService;
import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public User getUser() {
        logger.debug("Getting user..");
        return repository.loadUser();
    }
}
