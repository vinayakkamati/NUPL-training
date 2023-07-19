package com.neptune.taskmanagement.repository.Impl;

import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.repository.ProjectJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectJpaRepositoryImplTest {
    @Autowired
    ProjectJpaRepository projectJpaRepository;

    @Test
    void findById() {
        Project project = new Project("name", LocalDate.now());
        projectJpaRepository.save(project);
        Optional<Project> savedProject = projectJpaRepository.findById(project.getId());
        assertEquals(savedProject.get().getName(),project.getName());
    }

    @Test
    void save() {
        Project project = new Project(2L, "name", LocalDate.now());
        assertNotNull(projectJpaRepository.save(project));
    }
}