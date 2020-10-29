package com.mscharhag.mockmvc;

public class Product {
    private final String name;
    private final String description;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
