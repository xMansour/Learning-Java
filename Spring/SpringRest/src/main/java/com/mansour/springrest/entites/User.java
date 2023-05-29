package com.mansour.springrest.entites;

import java.util.Arrays;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String[] languages;

    private Address address;

    public User(String firstName, String lastName, int age, String[] languages, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.languages = languages;
        this.address = address;
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

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", languages=" + Arrays.toString(languages) +
                ", address=" + address +
                '}';
    }
}
