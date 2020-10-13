package com.mscharhag.authorization;

public class Project {

    private final int id;
    private final String owner;
    private String name;

    public Project(int id, String owner, String name) {
        this.id = id;
        this.owner = owner;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }
}
