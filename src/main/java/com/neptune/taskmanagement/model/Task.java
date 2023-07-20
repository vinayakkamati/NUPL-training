package com.neptune.taskmanagement.model;

import com.neptune.taskmanagement.enums.TaskStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private LocalDate dateCreated;

    private LocalDate dueDate;

    private TaskStatus status;

    public Task(){

    }

    public Task(String name, String description, LocalDate dateCreated, LocalDate dueDate, TaskStatus status) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Task(Long id, String name, String description, LocalDate dateCreated, LocalDate dueDate, TaskStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", dueDate=" + dueDate +
                ", status=" + status +
                '}';
    }
}
