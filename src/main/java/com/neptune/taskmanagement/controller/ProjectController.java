package com.neptune.taskmanagement.controller;

import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.service.IProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private final IProjectService iProjectService;

    public ProjectController(IProjectService iProjectService) {
        this.iProjectService = iProjectService;
    }

    @GetMapping(value = "/{id}")
    public Project findOne(@PathVariable Long id){
        return iProjectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/create")
    public void createProject(@RequestBody Project project){
        iProjectService.saveProject(project);
    }
}
