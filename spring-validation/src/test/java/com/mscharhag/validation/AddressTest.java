package com.mscharhag.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressTest {

    @Test
    public void creationFailsInvalidCity() {
        assertThrows(ConstraintViolationException.class, () -> {
            new Address("Fooway", null, "12345", "Baz");
        });

    }
}
