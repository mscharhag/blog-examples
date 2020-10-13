package com.mscharhag.authorization;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectAccessHandlerTest {

    private ProjectRepository repository = mock(ProjectRepository.class);
    private AuthenticatedUserService service = mock(AuthenticatedUserService.class);
    private ProjectAccessHandler accessHandler = new ProjectAccessHandler(repository, service);
    private User john = new User("John", "password", Collections.emptyList());

    @Test
    public void canUpdateProjectName_isOwner() {
        Project project = new Project(1, "John", "John's project");
        when(repository.findById(1)).thenReturn(project);
        when(service.getAuthenticatedUser()).thenReturn(john);
        assertTrue(accessHandler.canUpdateProjectName(1));
    }

    @Test
    public void canUpdateProjectName_isNotOwner() {
        Project project = new Project(1, "Anna", "Anna's project");
        when(repository.findById(1)).thenReturn(project);
        when(service.getAuthenticatedUser()).thenReturn(john);
        assertFalse(accessHandler.canUpdateProjectName(1));
    }
}
