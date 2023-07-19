package com.neptune.taskmanagement.repository;

import com.neptune.taskmanagement.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IProjectRepository extends CrudRepository<Project, Long> {
    Optional<Project> findByName(String name);

    List<Project> findByDateCreatedBetween(LocalDate start, LocalDate end);
}
