package com.example.CrudWithAllDBRelationship.controller;

import com.example.CrudWithAllDBRelationship.domain.booleanTest.BooleanTest;
import com.example.CrudWithAllDBRelationship.repository.BooleanTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooleanTestController {
    @Autowired
    private BooleanTestRepository booleanTestRepository;

    @PostMapping("/boolean")
    public BooleanTest create(BooleanTest booleanTest){
        return booleanTestRepository.save(booleanTest);
    }
}
