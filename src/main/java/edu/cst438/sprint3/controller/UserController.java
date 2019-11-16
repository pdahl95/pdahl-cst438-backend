package edu.cst438.sprint3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.cst438.sprint3.model.User;
import edu.cst438.sprint3.repositories.UserRepository;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    // Get all the users in the database 
    @GetMapping("Users/all")
    public List<User> getAll () {
        List<User> result = userRepository.findAll();
        return result;
    }
    // Add users to the database
    @PostMapping("/Users/add/")
    public User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Get users by ID 
    @GetMapping("/Users/get/{id}")
    public User getUserById(@PathVariable final String id) {
        final User result = userRepository.findByUserId(id);
        return result;
    }	

   

}