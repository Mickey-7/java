package com.example.springboottransaction.repository;

import com.example.springboottransaction.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO employee "+"(empId, empName) VALUES (?,?)";
        getJdbcTemplate().update(sql,
                employee.getEmpId(),
                employee.getEmpName()
        );
    }

    @Override
    public void deleteEmployeeById(String empId) {
        String sql = "DELETE FROM employee WHERE empId = ?";
           getJdbcTemplate().update(sql, empId);
    }
}
