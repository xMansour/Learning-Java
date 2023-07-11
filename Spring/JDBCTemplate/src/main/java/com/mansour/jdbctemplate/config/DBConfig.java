package com.mansour.jdbctemplate.config;

import com.mansour.jdbctemplate.entity.Employee;
import com.mansour.jdbctemplate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBConfig implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("DROP TABLE IF EXISTS EMPLOYEE");
        jdbcTemplate.execute("CREATE TABLE EMPLOYEE(id int AUTO_INCREMENT primary key, firstName varchar(20), lastName varchar(20), department varchar(20))");

        String query =
                "select count(*) "
                        + "from information_schema.tables "
                        + "where table_name = ? and table_schema = 'dbo'";
        Integer result = jdbcTemplate.queryForObject(query, Integer.class, "EMPLOYEE");
        if (result == 0) {
            employeeRepository.addEmployee(new Employee("Mahmoud", "Mansour", "Software Development"));
            employeeRepository.addEmployee(new Employee("Ahmed", "Ali", "IT"));

        }

    }
}
