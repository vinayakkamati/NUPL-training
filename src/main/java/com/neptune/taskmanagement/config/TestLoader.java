package com.neptune.taskmanagement.config;

import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.repository.IProjectRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestLoader implements ApplicationContextAware {
    @Autowired
    IProjectRepository projectRepository;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        projectRepository.save(new Project(1L,"My project 1", LocalDate.now()));
        projectRepository.save(new Project(2L, "My project 3", LocalDate.now()));
        projectRepository.save(new Project(3L,"My project 2", LocalDate.now()));
        projectRepository.save(new Project(4L,"My project 4", LocalDate.now()));
    }
}
