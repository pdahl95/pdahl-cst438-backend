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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "Get all the users from the User table.", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrived all users from User table."),
        @ApiResponse(code = 403, message = "Access Forbidden."),
        @ApiResponse(code = 404, message = "Not found."),
    })
    @GetMapping("Users/all")
    public List<User> getAll () {
        List<User> result = userRepository.findAll();
        return result;
    }
    @ApiOperation(value = "Add a user to to the User table.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully added a users to the User table."),
        @ApiResponse(code = 403, message = "Access Forbidden."),
        @ApiResponse(code = 404, message = "Not found."),
    })
    @PostMapping("/Users/add/")
    public User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value = "Get a user base on the User ID.")
    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable final String id) {
        final User result = userRepository.findByUserId(id);
        return result;
    }

    @ApiOperation(value = "Get a user base on the User email(username).")
    @GetMapping("/email/{email}")
     public User findByUserName(@PathVariable final String email) {
         final User result = userRepository.findByUserName(email);
         return result;
     }
   

}