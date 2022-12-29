package org.example;

import java.time.LocalDate;

public class EmployeeOld {
    private String name;
    private LocalDate birthDay;
    private boolean sex;

    public EmployeeOld(String name, LocalDate birthDay, boolean sex) {
        this.name = name;
        this.birthDay = birthDay;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public boolean sex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

}
