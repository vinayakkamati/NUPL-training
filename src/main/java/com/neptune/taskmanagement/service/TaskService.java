package com.neptune.taskmanagement.service;

import com.neptune.taskmanagement.exception.TaskNotSavedException;
import com.neptune.taskmanagement.model.Task;

public interface TaskService {
    Iterable<Task> findAll();

    Task save(Task task) throws TaskNotSavedException;
}
