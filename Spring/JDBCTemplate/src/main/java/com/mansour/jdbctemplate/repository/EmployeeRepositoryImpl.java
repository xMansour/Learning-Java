package com.mansour.jdbctemplate.repository;

import com.mansour.jdbctemplate.entity.Employee;
import com.mansour.jdbctemplate.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM EMPLOYEE", new EmployeeMapper());
    }

    @Override
    public Employee getEmployee(int id) {
        return jdbcTemplate.queryForObject("SELECT FROM EMPLOYEE WHERE ID = ?", new Object[]{id}, new EmployeeMapper());
    }

    @Override
    public void addEmployee(Employee employee) {
        jdbcTemplate.update("INSERT INTO EMPLOYEE(firstName, lastName, department) VALUES (?, ?, ?)", new Object[]{employee.getFirstName(), employee.getLastName(), employee.getDepartment()});
    }

    @Override
    public void deleteEmployee(int id) {
        jdbcTemplate.update("DROP FROM EMPLOYEE WHERE ID = ?", new Object[]{id});
    }

}
