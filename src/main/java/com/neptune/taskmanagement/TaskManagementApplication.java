package com.neptune.taskmanagement;

import com.neptune.taskmanagement.model.Project;
import com.neptune.taskmanagement.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class TaskManagementApplication {

	@Autowired
	IProjectService iProjectService;

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

	@PostConstruct
	public void postConstruct(){
		Project project = new Project(1L,"My project", LocalDate.now());
		iProjectService.saveProject(project);

		Optional<Project> project1 = iProjectService.findById(1L);
		project1.ifPresent(System.out::println);
	}

}
