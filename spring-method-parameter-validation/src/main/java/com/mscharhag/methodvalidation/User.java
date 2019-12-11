package com.mscharhag.methodvalidation;

import javax.validation.constraints.NotBlank;

public class User {

    @NotBlank
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
