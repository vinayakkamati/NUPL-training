package com.neptune.taskmanagement.repository;

import com.neptune.taskmanagement.model.Project;

import java.util.Optional;

public interface IProjectRepository {
    Optional<Project> findById(Long id);

    Project saveProject(Project project);

}
