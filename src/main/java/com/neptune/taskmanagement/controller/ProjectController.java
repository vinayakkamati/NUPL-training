package com.neptune.taskmanagement.controller;

import com.neptune.taskmanagement.dto.ProjectDto;
import com.neptune.taskmanagement.mapper.ProjectMapper;
import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.service.IProjectService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private final IProjectService iProjectService;

    private ProjectMapper projectMapper = Mappers.getMapper(ProjectMapper.class);

    public ProjectController(IProjectService iProjectService) {
        this.iProjectService = iProjectService;
    }

    @GetMapping(value = "/{id}")
    public ProjectDto findOne(@PathVariable Long id){
        Project project = iProjectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return projectMapper.ProjectToDto(project);
    }

    @PostMapping(value = "/create")
    public void createProject(@RequestBody ProjectDto projectDto){

        iProjectService.saveProject(projectMapper.DtoToProject(projectDto));
    }
}
