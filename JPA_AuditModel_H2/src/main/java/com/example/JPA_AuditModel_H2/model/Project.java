package com.example.JPA_AuditModel_H2.model;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project extends AuditModel{

    @Id
    @Column(name = "project_id")
    @GeneratedValue
    private Long projectId;

    @Column(name = "title")
    private String title;

    public Project(){}

    public Project(Long projectId, String title) {
        this.projectId = projectId;
        this.title = title;
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

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", title='" + title + '\'' +
                '}';
    }
}
