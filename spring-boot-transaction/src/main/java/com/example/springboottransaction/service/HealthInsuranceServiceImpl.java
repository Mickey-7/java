package com.example.springboottransaction.service;

import com.example.springboottransaction.domain.EmployeeHealthInsurance;
import com.example.springboottransaction.repository.HealthInsuranceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthInsuranceServiceImpl implements HealthInsuranceService {

    @Autowired
    private HealthInsuranceDao healthInsuranceDao;

    @Override
    public void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) {
        healthInsuranceDao.registerEmployeeHealthInsurance(employeeHealthInsurance);
    }

    @Override
    public void deleteEmployeeHealthInsuranceById(String empId) {
        healthInsuranceDao.deleteEmployeeHealthInsuranceById(empId);
    }
}
