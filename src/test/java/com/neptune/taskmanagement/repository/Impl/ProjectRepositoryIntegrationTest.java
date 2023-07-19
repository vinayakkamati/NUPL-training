package com.neptune.taskmanagement.repository.Impl;

import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.repository.IProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    IProjectRepository projectRepository;

    @Test
    public void findAllPaginated(){
        Page<Project> retrievedProject = projectRepository.findAll(PageRequest.of(0,2));
        assertEquals(retrievedProject.getSize(),2);
    }

    @Test
    public void findAllSorted(){
        List<Project> retrievedProject = (List<Project>) projectRepository.findAll(Sort.by(Sort.Order.asc("name")));

        List<Project> sortedProject = retrievedProject.stream().collect(Collectors.toList());
        sortedProject.sort(Comparator.comparing(Project::getName));

        assertEquals(sortedProject,retrievedProject);
    }

    @Test
    public void findAllPaginatedAndSorted(){
        Page<Project> retrievedProject = projectRepository
                .findAll(PageRequest.of(0,2, Sort.by(Sort.Order.asc("name"))));

        assertEquals(retrievedProject.getContent().size(), 2);
    }
}
