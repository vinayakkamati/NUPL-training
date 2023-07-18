package com.neptune.taskmanagement.service;

import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {TestConfig.class})
public class ProjectServiceIntegrationTest {

    @Autowired
    private IProjectService projectService;

    @Test
    public void whenSavingProject_thenOk(){
        Project savedProject = projectService.saveProject(new Project(1L, "name", LocalDate.now()));
        assertNotNull(savedProject);
    }
}
