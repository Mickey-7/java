package com.example.paginatingsortingh2v2.service;

import com.example.paginatingsortingh2v2.domain.EmployeeEntity;
import com.example.paginatingsortingh2v2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy){
        PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<EmployeeEntity> pagedResult = employeeRepository.findAll(paging);

        //4. Pagination and sorting techniques

        //4.1. Paging WITHOUT sorting
        //To apply only pagination in result set, we shall create Pageable object without any Sort information.
        //Pageable paging = PageRequest.of(pageNo, pageSize);
        //Page<EmployeeEntity> pagedResult = repository.findAll(paging);

        //4.2. Paging WITH sorting
        //To apply only pagination in result set, we shall create Pageable object with desired Sort column name.
        //Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("email"));
        //Page<EmployeeEntity> pagedResult = repository.findAll(paging);

        //By default, records are ordered in DESCENDING order. To choose ASCENDING order, use .ascending() method.
        //Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("email").ascending());
        //Page<EmployeeEntity> pagedResult = repository.findAll(paging);

        //4.3. Sorting only
        //If there is no need to page, and only sorting is required, we can create Sort object for that.
        //Sort sortOrder = Sort.by("email");
        //List<EmployeeEntity> list = repository.findAll(sortOrder);

        //If we wish to apply sorting on multiple columns or group by sort,
        //then that is also possible by creating Sort using simple builder pattern steps.
        //Sort emailSort = Sort.by("email");
        //Sort firstNameSort = Sort.by("first_name");
        //Sort groupBySort = emailSort.and(firstNameSort);
        //List<EmployeeEntity> list = repository.findAll(groupBySort);

        if (pagedResult.hasContent()){
            return pagedResult.getContent();
        }else {
            return new ArrayList<EmployeeEntity>();
        }
    }
}
