package com.example.ObjectMapperDemo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
}
