package com.mansour.jdbctemplate.repository;

import com.mansour.jdbctemplate.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();

    Employee getEmployee(int id);

    void addEmployee(Employee employee);

    void deleteEmployee(int id);

}
