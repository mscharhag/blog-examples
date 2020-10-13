package com.mscharhag.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping("/{id}")
    public ResponseEntity<Void> updateName(
            @PathVariable("id") int id,
            @RequestParam("name") String name
    ) {
        service.updateProjectName(id, name);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable("id") int id) {
        service.deleteProject(id);
        return ResponseEntity.ok().build();
    }
}
