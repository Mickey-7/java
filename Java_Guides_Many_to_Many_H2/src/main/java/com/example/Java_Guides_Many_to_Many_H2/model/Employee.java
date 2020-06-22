package com.example.Java_Guides_Many_to_Many_H2.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(cascade =  CascadeType.ALL)
            @JoinTable(
                    name = "employees_projects",
                    joinColumns = {
                            @JoinColumn(name = "employee_id")
                    },
                    inverseJoinColumns = {
                            @JoinColumn(name = "project_id")
                    }
            )
    private List<Project> projects = new ArrayList<>();

    public Employee(){}

    public Employee(Long employeeId, String firstName, String lastName, List<Project> projects) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.projects = projects;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", projects=" + projects +
                '}';
    }
}
