package com.mansour.springbootcrud.service;

import com.mansour.springbootcrud.dao.UserJPARepository;
import com.mansour.springbootcrud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserJPAServiceImpl implements UserService {
    @Autowired
    private UserJPARepository userJPARepository;
    @Override
    public List<User> getUsers() {
        return userJPARepository.findAll();
    }

    @Override
    public User getUser(int userId) {
        return userJPARepository.findById(userId).orElse(null);
    }

    @Override
    public void addUser(User user) {
        userJPARepository.save(user);
    }

    @Override
    public void removeUser(int userId) {
        userJPARepository.deleteById(userId);
    }

    @Override
    public void updateUser(User user) {
        User currentUser = getUser(user.getId());
        currentUser.setAge(user.getAge());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        userJPARepository.save(currentUser);
    }
}
