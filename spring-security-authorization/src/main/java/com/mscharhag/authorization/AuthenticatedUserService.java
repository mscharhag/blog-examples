package com.mscharhag.authorization;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatedUserService {
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }
}
