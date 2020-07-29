package com.mscharhag.springjsonschema.validation;

public class JsonSchemaValidationException extends RuntimeException {

    public JsonSchemaValidationException(String message) {
        super(message);
    }

    public JsonSchemaValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
