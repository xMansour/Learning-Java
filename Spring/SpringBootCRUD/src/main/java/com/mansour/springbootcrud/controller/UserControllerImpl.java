package com.mansour.springbootcrud.controller;

import com.mansour.springbootcrud.entity.User;
import com.mansour.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserControllerImpl implements UserController {
    @Autowired
    @Qualifier("userJPAServiceImpl")
    private UserService userService;

    @Override
    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @Override
    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @Override
    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @Override
    @DeleteMapping("/user/{userId}")
    public void removeUser(@PathVariable int userId) {
        userService.removeUser(userId);
    }

    @Override
    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}
