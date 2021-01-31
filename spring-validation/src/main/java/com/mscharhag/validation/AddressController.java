package com.mscharhag.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
public class AddressController {

    @PostMapping("/address")
    public void createAddress(@Valid @RequestBody Address address) {
        // ..
    }

}
