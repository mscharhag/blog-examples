package com.mscharhag.authorization;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component("projectAccess")
public class ProjectAccessHandler {

    private final ProjectRepository projectRepository;
    private final AuthenticatedUserService authenticatedUserService;

    public ProjectAccessHandler(
            ProjectRepository projectRepository,
            AuthenticatedUserService authenticatedUserService
    ) {
        this.projectRepository = projectRepository;
        this.authenticatedUserService = authenticatedUserService;
    }

    public boolean canUpdateProjectName(int id) {
        return isProjectOwner(id);
    }

    public boolean canDeleteProject(int id) {
        return isProjectOwner(id);
    }

    private boolean isProjectOwner(int id) {
        User user = authenticatedUserService.getAuthenticatedUser();
        Project project = projectRepository.findById(id);
        return (project.getOwner().equals(user.getUsername()));
    }
}
