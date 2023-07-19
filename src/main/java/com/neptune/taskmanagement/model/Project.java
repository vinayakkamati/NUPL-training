package com.neptune.taskmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate dateCreated;

    public Project() {
    }

    public Project(String name, LocalDate localDate) {
        this.name = name;
        this.dateCreated = localDate;
    }

    public Project(Long id, String name, LocalDate localDate) {
        this.id = id;
        this.name = name;
        this.dateCreated = localDate;
    }

    public Project(Project project) {
        this(project.getId(), project.getName(), project.getDateCreated());
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
                ", localDate=" + dateCreated +
                '}';
    }
}
