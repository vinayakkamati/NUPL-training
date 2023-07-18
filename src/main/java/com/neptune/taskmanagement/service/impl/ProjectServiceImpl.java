package com.neptune.taskmanagement.service.impl;

import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.repository.IProjectRepository;
import com.neptune.taskmanagement.service.IProjectService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    public ProjectServiceImpl() {
        super();
    }

    @Autowired
    private IProjectRepository iProjectRepository;

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Finding Project by id " + id);
        return iProjectRepository.findById(id);
    }

    @Override
    public Project saveProject(Project project) {
        LOG.debug("Finding Project " + project);
        return iProjectRepository.saveProject(project);
    }
}
