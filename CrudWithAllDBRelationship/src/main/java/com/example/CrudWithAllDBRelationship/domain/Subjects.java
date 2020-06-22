package com.example.CrudWithAllDBRelationship.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
