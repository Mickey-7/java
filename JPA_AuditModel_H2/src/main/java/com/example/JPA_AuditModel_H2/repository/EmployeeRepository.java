package com.example.JPA_AuditModel_H2.repository;

import com.example.JPA_AuditModel_H2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
