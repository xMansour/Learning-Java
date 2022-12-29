package org.example;

import java.time.LocalDate;
import java.time.Period;

public class EmployeeOldAdapter implements Employee {
    private final EmployeeOld instance;

    public EmployeeOldAdapter(EmployeeOld employeeOld) {
        this.instance = employeeOld;
    }

    @Override
    public String getFirstName() {
        return this.instance.getName().substring(0, instance.getName().indexOf(" "));
    }

    @Override
    public String getLastName() {
        return this.instance.getName().substring(instance.getName().indexOf(" "));
    }

    @Override
    public int getAge() {
        return Period.between(this.instance.getBirthDay(), LocalDate.now()).getYears();
    }

    @Override
    public String getSex() {
        if (!this.instance.sex())
            return "Female";
        else
            return "Male";
    }


    @Override
    public String toString() {
        return "EmployeeOldAdapter" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                ", sex='" + getSex() + '\'' +
                '}';
    }
}
