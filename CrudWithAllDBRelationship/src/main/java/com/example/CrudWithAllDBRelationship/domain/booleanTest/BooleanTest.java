package com.example.CrudWithAllDBRelationship.domain.booleanTest;

import com.example.CrudWithAllDBRelationship.config.BooleanConfig;
import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class BooleanTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = BooleanConfig.class)
    private Boolean isPublished;
}
