package com.mansour.springrest.controllers;

import com.mansour.springrest.entites.Address;
import com.mansour.springrest.entites.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @GetMapping("/list")
    public List<User> listUsers(){
        List<User> users = new ArrayList<>();
        Address address = new Address("Sheben", "Egypt", "13711");
        User user = new User("Mahmoud", "Mansour", 26, new String[]{"Arabic", "English"}, address);
        users.add(user);
        return users;
    }
}
