package com.mscharhag.methodvalidation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@RestController
@Validated
public class UserController {

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable @Pattern(regexp = "\\w{2}\\d{8}") String userId) {
        return ResponseEntity.ok(new User("john"));
    }
}
