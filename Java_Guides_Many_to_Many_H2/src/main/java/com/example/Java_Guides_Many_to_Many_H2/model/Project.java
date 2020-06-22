package com.example.Java_Guides_Many_to_Many_H2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue
    private Long projectId;

    @Column(name = "title")
    private String title;

    // the "projects" below pertains to the projects on Employee class with @ManyToMany annotations
    @ManyToMany( mappedBy = "projects", cascade =  CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employees = new ArrayList<>();

    public Project(){}

    public Project(Long projectId, String title, List<Employee> employees) {
        this.projectId = projectId;
        this.title = title;
        this.employees = employees;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", title='" + title + '\'' +
                ", employees=" + employees +
                '}';
    }
}
