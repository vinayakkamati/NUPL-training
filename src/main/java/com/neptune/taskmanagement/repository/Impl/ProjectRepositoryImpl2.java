//package com.neptune.taskmanagement.repository.Impl;
//
//import com.neptune.taskmanagement.model.Project;
//import com.neptune.taskmanagement.repository.IProjectRepository;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//@Profile("prod")
//public class ProjectRepositoryImpl2 implements IProjectRepository {
//    List<Project> projects = new ArrayList<>();
//
//    @Override
//    public Optional<Project> findById(Long id) {
//        return projects.stream().filter(p -> p.getId() == id).findFirst();
//    }
//
//    @Override
//    public Project saveProject(Project project) {
//        Project existingProject = findById(project.getId()).orElse(null);
//        if(existingProject == null){
//            projects.add(project);
//        }else {
//            projects.remove(existingProject);
//            Project newProject = new Project(project);
//        }
//        return project;
//    }
//}
