package com.mansour.jdbctemplate.mapper;

import com.mansour.jdbctemplate.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("department"));
    }
}
