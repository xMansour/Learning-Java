package com.mansour.springrest.controllers;

import com.mansour.springrest.entites.Address;
import com.mansour.springrest.entites.User;
import com.mansour.springrest.exceptions.UserNotFoundException;
import com.mansour.springrest.utils.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {
    private List<User> users;


    @PostConstruct
    public void initialize(){
        users = new ArrayList<>();
        Address address = new Address("Sheben", "Egypt", "13711");
        users.add(new User("Mahmoud", "Mansour", 26, new String[]{"Arabic", "English"}, address));
        users.add(new User("Ahmed", "Ali", 23, new String[]{"Arabic", "French"}, address));
        users.add(new User("Mostafa", "Hassan", 28, new String[]{"Arabic", "German"}, address));
    }
    @GetMapping("/list")
    public List<User> listUsers(){
        return users;
    }


    @GetMapping("/get/{userId}")
    public User getUser(@PathVariable int userId){
        System.out.println("userId = " + userId);
        if(userId >= users.size() || userId<0)
            throw new UserNotFoundException("User not found with id: "+userId);
        return users.get(userId);
    }


}
