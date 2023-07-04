package com.mansour.springbootcrud.service;

import com.mansour.springbootcrud.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUser(int userId);

    void addUser(User user);

    void removeUser(int userId);

    void updateUser(User user);
}
