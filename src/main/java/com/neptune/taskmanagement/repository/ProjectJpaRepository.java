package com.neptune.taskmanagement.repository;

import com.neptune.taskmanagement.model.Project;

import java.util.Optional;

public interface ProjectJpaRepository {
    Optional<Project> findById(Long id);

    Project save(Project project);
}
