package com.mscharhag.authorization;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProjectRepository {

    private final Map<Integer, Project> projects = Map.of(
            // Define 3 test projects
            // John is the owner of the first project, both others are owned by Anna
            1, new Project(1, "John", "Cool project from John"),
            2, new Project(2, "Anna", "Anna's nice project"),
            3, new Project(3, "Anna", "Another project by Anna")
    );

    public Project findById(int id) {
        return projects.get(id);
    }
}
