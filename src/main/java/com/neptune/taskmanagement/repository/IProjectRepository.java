package com.neptune.taskmanagement.repository;

import com.neptune.taskmanagement.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IProjectRepository extends CrudRepository<Project, Long> {
    Optional<Project> findByName(String name);
}
