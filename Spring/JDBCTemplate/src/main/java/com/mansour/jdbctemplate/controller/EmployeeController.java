package com.mansour.jdbctemplate.controller;

import com.mansour.jdbctemplate.entity.Employee;
import com.mansour.jdbctemplate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployees();
    }


    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeRepository.getEmployee(id);
    }

    @PostMapping("/")
    public void addEmployee(@RequestBody Employee employee){
        employeeRepository.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeRepository.deleteEmployee(id);
    }

}
