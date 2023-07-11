package com.mansour.jdbctemplate.controller;

import com.mansour.jdbctemplate.entity.Employee;
import com.mansour.jdbctemplate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployees();
    }
}
