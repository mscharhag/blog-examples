package com.mscharhag.archunit.layers.service.impl;

import com.mscharhag.archunit.layers.repository.UserRepository;
import com.mscharhag.archunit.layers.service.UserService;
import com.mscharhag.archunit.model.User;
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
