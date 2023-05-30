package com.mansour.crm.services;

import com.mansour.crm.entities.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();


    void addUser(User user);

    User getUser(int userId);

    void deleteUser(int userId);
}
