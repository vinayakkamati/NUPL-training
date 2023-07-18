package com.neptune.taskmanagement.service;

import com.neptune.taskmanagement.model.Project;

import java.util.Optional;

public interface IProjectService {

    Optional<Project> findById(Long id);

    Project saveProject(Project project);
}
