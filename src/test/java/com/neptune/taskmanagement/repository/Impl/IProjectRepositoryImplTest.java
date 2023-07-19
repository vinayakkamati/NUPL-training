package com.neptune.taskmanagement.repository.Impl;

import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.repository.IProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
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


    @Test
    void findByDateCreatedBetween() {
        Project oldProject = new Project(2L, "name", LocalDate.now().minusYears(1));
        projectRepository.save(oldProject);

        Project newProject = new Project(2L, "name3", LocalDate.now());
        projectRepository.save(newProject);


        Project newProject2 = new Project(2L, "name2", LocalDate.now());
        projectRepository.save(newProject2);

        List<Project> savedProject = projectRepository
                .findByDateCreatedBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));

        assertEquals(savedProject.size(), 2);
    }
}