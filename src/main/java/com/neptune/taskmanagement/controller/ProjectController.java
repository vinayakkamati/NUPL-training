package com.neptune.taskmanagement.controller;

import com.neptune.taskmanagement.model.Project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @GetMapping("/1")
    public Project firstOne(){
        return new Project("name", LocalDate.now());
    }
}
