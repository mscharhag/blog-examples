package com.mscharhag.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService service;

    @Test
    public void updateAddressInvalidCustomerId() {
        Address newAddress = newAddress();
        assertThrows(ConstraintViolationException.class, () -> {
            service.updateAddress("ab123456", newAddress);
        });
    }

    @Test
    public void updateAddressInvalidAddress() {
        Address newAddress = newAddress();
        newAddress.setStreet(null);
        assertThrows(ConstraintViolationException.class, () -> {
            service.updateAddress("ab12345678", newAddress);
        });
    }

    @Test
    public void updateAddressOk() {
        Address newAddress = newAddress();
        service.updateAddress("ab12345678", newAddress);
    }

    private Address newAddress() {
        Address address = new Address();
        address.setStreet("Fooway");
        address.setCity("Bar");
        address.setZipCode("12345");
        address.setCountry("Baz");
        return address;
    }

}
