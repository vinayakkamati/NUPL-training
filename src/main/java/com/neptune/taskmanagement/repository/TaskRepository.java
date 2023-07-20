package com.neptune.taskmanagement.repository;

import com.neptune.taskmanagement.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
