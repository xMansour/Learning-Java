package com.mansour.crm.controllers;

import com.mansour.crm.entities.User;
import com.mansour.crm.exceptions.UserException;
import com.mansour.crm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/")
    public List<User> listUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId){
        User user = userService.getUser(userId);
        if (user == null)
            throw new UserException("User not found with id: "+userId);
        return userService.getUser(userId);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }

    @PostMapping("/users/")
    public void addUser(){

    }
}
