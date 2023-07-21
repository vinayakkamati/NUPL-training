package com.neptune.taskmanagement.service.impl;

import com.neptune.taskmanagement.enums.TaskStatus;
import com.neptune.taskmanagement.exception.TaskNotSavedException;
import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.model.Task;
import com.neptune.taskmanagement.repository.IProjectRepository;
import com.neptune.taskmanagement.service.IProjectService;
import com.neptune.taskmanagement.service.TaskService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectServiceImpl implements IProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final IProjectRepository iProjectRepository;
    private final TaskService taskService;

    public ProjectServiceImpl(IProjectRepository iProjectRepository, TaskService taskService) {
        this.iProjectRepository = iProjectRepository;
        this.taskService = taskService;
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Finding Project by id " + id);
        return iProjectRepository.findById(id);
    }

    @Override
    public Project saveProject(Project project) {
        LOG.debug("Finding Project " + project);
        project.setDateCreated(LocalDate.now());
        return iProjectRepository.save(project);
    }

    @Transactional(rollbackFor = TaskNotSavedException.class)
    @Override
    public void createProjectWithTasks() throws TaskNotSavedException {
        Project project = new Project("Project 1", LocalDate.now());

        Project newProject = iProjectRepository.save(project);

        Task task1 = new Task("Task 1", "Project 1 Task 1", LocalDate.now(), LocalDate.now()
                .plusDays(7), TaskStatus.TO_DO);

        taskService.save(task1);

        Set<Task> tasks = new HashSet<>();
        tasks.add(task1);

        newProject.setTasks(tasks);

        iProjectRepository.save(newProject);
    }

    @Override
    public Iterable<Project> findAll() {
        return iProjectRepository.findAll();
    }
}
