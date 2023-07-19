package com.neptune.taskmanagement.repository.Impl;

import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.repository.IProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class IProjectRepositoryImplTest {

    @Autowired
    IProjectRepository projectRepository;

    @Test
    void findById() {
        Project project = new Project(2L, "name", LocalDate.now());
        projectRepository.save(project);
        Optional<Project> savedProject = projectRepository.findById(project.getId());
        assertEquals(savedProject.get().getName(),project.getName());
    }

    @Test
    void findByName() {
        Project project = new Project(2L, "name", LocalDate.now());
        projectRepository.save(project);
        Optional<Project> savedProject = projectRepository.findByName(project.getName());
        assertEquals(savedProject.get().getDateCreated(),project.getDateCreated());
    }

    @Test
    void saveProject() {
        Project project = new Project(2L, "name", LocalDate.now());
        assertNotNull(projectRepository.save(project));
    }
}