package com.mscharhag.validation;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Service
@Validated
public class CustomerService {

    private final ValidationFacade validationFacade;

    public CustomerService(ValidationFacade validationFacade) {
        this.validationFacade = validationFacade;
    }

    public void updateAddress(
            @Pattern(regexp = "\\w{2}\\d{8}") String customerId,
            @Valid Address newAddress
    ) {
        // ..
    }



    public void updateAddress2(String customerId, Address newAddress) {
        validationFacade.validate(newAddress);
        // ...
    }
}
