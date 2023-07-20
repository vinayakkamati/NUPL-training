package com.neptune.taskmanagement.service.impl;

import com.neptune.taskmanagement.exception.TaskNotSavedException;
import com.neptune.taskmanagement.model.Task;
import com.neptune.taskmanagement.repository.TaskRepository;
import com.neptune.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) throws TaskNotSavedException {
        throw new TaskNotSavedException("Unable to save task");

//        throw new RuntimeException("Unable to save task");
//        return taskRepository.save(task);
    }
}
