//package com.neptune.taskmanagement.service.impl;
//
//import com.neptune.taskmanagement.model.Project;
//import com.neptune.taskmanagement.repository.IProjectRepository;
//import com.neptune.taskmanagement.service.IProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ProjectServiceImplSetterInjection implements IProjectService {
//
//    @Autowired
//    private IProjectRepository iProjectRepository;
//
//    @Override
//    public Optional<Project> findById(Long id) {
//        return iProjectRepository.findById(id);
//    }
//
//    @Override
//    public Project saveProject(Project project) {
//        return iProjectRepository.saveProject(project);
//    }
//
////    @Autowired
////    public void setiProjectRepository(IProjectRepository iProjectRepository) {
////        this.iProjectRepository = iProjectRepository;
////    }
//}
//
