package com.mansour.crm.services;

import com.mansour.crm.dao.UserDAO;
import com.mansour.crm.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public User getUser(int userId) {
        return userDAO.getUser(userId);
    }
    @Transactional
    @Override
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
}
