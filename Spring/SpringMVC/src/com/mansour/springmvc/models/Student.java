package com.mansour.springmvc.models;


import com.mansour.springmvc.annotations.CourseCode;

import javax.validation.constraints.*;

public class Student {

    @NotNull
    @Size(min = 1)
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 chars/digits")
    private String firstName;
    @NotNull(message = "Required not null")
    @Size(min = 1)
    private String lastName;

    @Min(value = 18, message = "Must be at least 18.")
    @Max(value = 30, message = "Must be below 30s.")
    private int age;

    @CourseCode(value = "Spr", message = "Must start with Spr.")
    private String courseCode;

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
