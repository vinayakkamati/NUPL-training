package com.neptune.taskmanagement.controller;

import com.neptune.taskmanagement.dto.ProjectDto;
import com.neptune.taskmanagement.mapper.ProjectMapper;
import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.service.IProjectService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

    private final IProjectService iProjectService;

    private ProjectMapper projectMapper = Mappers.getMapper(ProjectMapper.class);

    public ProjectController(IProjectService iProjectService) {
        this.iProjectService = iProjectService;
    }

    @GetMapping
    public String getProjects(Model model) {
        Iterable<Project> projects = iProjectService.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        projects.forEach(p -> projectDtos.add(projectMapper.ProjectToDto(p)));

        model.addAttribute("projects", projectDtos);
        return "projects";
    }

    @GetMapping("/new")
    public String newProject(Model model){
        model.addAttribute("project", new ProjectDto());
        return "new-project";
    }

    @PostMapping
    public String addProject(@Valid @ModelAttribute("project") ProjectDto projectDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "new-project";
        iProjectService.saveProject(projectMapper.DtoToProject(projectDto));
        return "redirect:/projects";
    }
}
