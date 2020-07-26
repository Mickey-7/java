package com.example.springboottransaction.service;

import com.example.springboottransaction.domain.Employee;
import com.example.springboottransaction.domain.EmployeeHealthInsurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private HealthInsuranceService healthInsuranceService;

    @Override
    @Transactional
    public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
        employeeService.insertEmployee(employee);
        if (employee.getEmpId().equals("emp1")){
            throw new RuntimeException("throwing exception to test transaction rollback");
        }
        healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
    }

    @Override
    @Transactional
    public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
        employeeService.deleteEmployeeById(employee.getEmpId());
        healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getEmpId());
    }
}
