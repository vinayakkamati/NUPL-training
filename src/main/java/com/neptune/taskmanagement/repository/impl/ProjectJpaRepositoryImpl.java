package com.neptune.taskmanagement.repository.impl;

import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.repository.ProjectJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class ProjectJpaRepositoryImpl implements ProjectJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<Project> findById(Long id) {
        Project entity = entityManager.find(Project.class, id);
        return Optional.ofNullable(entity);
    }

    @Override
    @Transactional
    public Project save(Project project) {
        entityManager.persist(project);
        return project;
    }
}
