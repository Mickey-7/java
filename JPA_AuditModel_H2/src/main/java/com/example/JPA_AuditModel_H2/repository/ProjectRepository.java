package com.example.JPA_AuditModel_H2.repository;

import com.example.JPA_AuditModel_H2.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
