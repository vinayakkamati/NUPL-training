package com.neptune.taskmanagement.repository.Impl;

import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("dev")
public class IProjectRepositoryImpl implements IProjectRepository {
    List<Project> projects = new ArrayList<>();

    @Value("${project.prefix}")
    private String prefix;

    @Value("${project.suffix}")
    private Integer suffix;

    public IProjectRepositoryImpl() {
        super();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Project saveProject(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        updateInternalId(project);
        if(existingProject == null){
            projects.add(project);
        }else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
        }
        return project;
    }

    private void updateInternalId(Project project) {
        project.setInternalId(prefix + "-" + project.getId()+ "-" + suffix);
    }
}
