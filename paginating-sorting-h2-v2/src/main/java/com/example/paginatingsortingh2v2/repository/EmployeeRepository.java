package com.example.paginatingsortingh2v2.repository;

import com.example.paginatingsortingh2v2.domain.EmployeeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Long> {
}
