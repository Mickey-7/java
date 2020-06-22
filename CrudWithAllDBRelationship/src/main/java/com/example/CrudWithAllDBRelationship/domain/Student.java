package com.example.CrudWithAllDBRelationship.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "student_details")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name")
    private String name;

    private String className;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Subjects> subjects;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Hobby> hobbies;

}
