package com.mscharhag.jsonschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.*;

import java.io.InputStream;
import java.util.Set;

public class Main {

    private static InputStream inputStreamFromClasspath(String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);

        try (
                InputStream jsonStream = inputStreamFromClasspath("example.json");
                InputStream schemaStream = inputStreamFromClasspath("example-schema.json")
        ) {
            JsonNode json = objectMapper.readTree(jsonStream);
            JsonSchema schema = schemaFactory.getSchema(schemaStream);
            Set<ValidationMessage> validationResult = schema.validate(json);

            // print validation errors
            if (validationResult.isEmpty()) {
                System.out.println("no validation errors :-)");
            } else {
                validationResult.forEach(vm -> System.out.println(vm.getMessage()));
            }
        }
    }
}
