package com.example.CrudWithAllDBRelationship.repository;

import com.example.CrudWithAllDBRelationship.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
