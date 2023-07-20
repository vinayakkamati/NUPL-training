package com.neptune.taskmanagement;
import com.neptune.taskmanagement.service.IProjectService;
import com.neptune.taskmanagement.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TaskManagementApplication {

	private static final Logger LOG = LoggerFactory.getLogger(TaskManagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

	@Autowired
	IProjectService projectService;

	@Autowired
	TaskService taskService;

	@PostConstruct
	public void postConstruct() {
		try {
			projectService.createProjectWithTasks();
		} catch (Exception e) {
			LOG.error("Error occurred in creating project with tasks", e);
		}

		LOG.info("Fetching all Projects");
		projectService.findAll()
				.forEach(p -> System.out.println(p.toString()));

		LOG.info("Fetching all tasks");
		taskService.findAll()
				.forEach(t -> System.out.println(t.toString()));
	}


}
