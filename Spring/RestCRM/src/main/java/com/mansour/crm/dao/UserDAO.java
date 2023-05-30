package com.mansour.crm.dao;

import com.mansour.crm.entities.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();


    void addUser(User user);

    User getUser(int userId);

    void deleteUser(int userId);

}
