package com.neptune.taskmanagement.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate dateCreated;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Set<Task> tasks;

    public Project() {
    }

    public Project(String name, LocalDate localDate) {
        this.name = name;
        this.dateCreated = localDate;
    }

    public Project(Long id, String name, LocalDate dateCreated, Set<Task> tasks) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.tasks = tasks;
    }

    public Project(Long id, String name, LocalDate localDate) {
        this.id = id;
        this.name = name;
        this.dateCreated = localDate;
    }

    public Project(Project project) {
        this(project.getId(), project.getName(), project.getDateCreated());
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", tasks=" + tasks +
                '}';
    }
}
