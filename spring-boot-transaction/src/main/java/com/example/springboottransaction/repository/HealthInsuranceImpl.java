package com.example.springboottransaction.repository;

import com.example.springboottransaction.domain.EmployeeHealthInsurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class HealthInsuranceImpl extends JdbcDaoSupport implements HealthInsuranceDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance) {
        String sql = "INSERT INTO employeeHealthInsurance "+"(empId, healthInsuranceSchemeName, coverageAmount) VALUES (?,?,?)";
        getJdbcTemplate().update(sql,
                employeeHealthInsurance.getEmpId(),
                employeeHealthInsurance.getHealthInsuranceScheme(),
                employeeHealthInsurance.getCoverageAmount()
        );
    }

    @Override
    public void deleteEmployeeHealthInsuranceById(String empId) {
        String sql = "DELETE FROM employeeHealthInsurance WHERE empId = ?";
        getJdbcTemplate().update(sql, empId);
    }
}
