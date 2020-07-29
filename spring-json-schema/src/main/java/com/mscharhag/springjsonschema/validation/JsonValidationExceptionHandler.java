package com.mscharhag.springjsonschema.validation;

import com.networknt.schema.ValidationMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class JsonValidationExceptionHandler {

    @ExceptionHandler(JsonValidationFailedException.class)
    public ResponseEntity<Map<String, Object>> onJsonValidationFailedException(JsonValidationFailedException ex) {
        List<String> messages = ex.getValidationMessages().stream()
                .map(ValidationMessage::getMessage)
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(Map.of(
            "message", "Json validation failed",
            "details", messages
        ));
    }
}
