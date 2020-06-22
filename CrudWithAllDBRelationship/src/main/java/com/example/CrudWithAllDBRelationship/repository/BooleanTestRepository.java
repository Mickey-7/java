package com.example.CrudWithAllDBRelationship.repository;

import com.example.CrudWithAllDBRelationship.domain.booleanTest.BooleanTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooleanTestRepository extends JpaRepository<BooleanTest, Long> {
}
