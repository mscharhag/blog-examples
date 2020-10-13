package com.mscharhag.authorization;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @PreAuthorize("@projectAccess.canUpdateProjectName(#id)")
    public void updateProjectName(int id, String newName) {
        // update project name ...

        System.out.printf("updating name of project %d to %s", id, newName);
    }

    @PreAuthorize("@projectAccess.canDeleteProject(#id)")
    public void deleteProject(int id) {
        // delete project ...

        System.out.printf("deleting project %d", id);
    }
}
