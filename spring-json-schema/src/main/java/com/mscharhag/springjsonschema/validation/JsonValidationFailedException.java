package com.mscharhag.springjsonschema.validation;

import com.networknt.schema.ValidationMessage;

import java.util.Set;

public class JsonValidationFailedException extends RuntimeException {
    private final Set<ValidationMessage> validationMessages;

    public JsonValidationFailedException(Set<ValidationMessage> validationMessages) {
        super("Json validation failed: " + validationMessages);
        this.validationMessages = validationMessages;
    }

    public Set<ValidationMessage> getValidationMessages() {
        return validationMessages;
    }
}
