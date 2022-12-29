package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdapterDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        Employee emp1 = new EmployeeNew("Mahmoud", "Mansour", 26, "Male");
        employees.add(emp1);

        //Employee emp2 = new EmployeeOld("Ahmed Youssef", LocalDate.of(1998, 1, 1), true);     //EmployeeOld doesn't implement Employee and can't be added to a List<Employee>

        EmployeeOld emp3 = new EmployeeOld("Ahmed Youssef", LocalDate.of(1998, 1, 1), true);    //we should use the legacy system as it is

        employees.add(new EmployeeOldAdapter(emp3));

        System.out.println(employees);

    }
}