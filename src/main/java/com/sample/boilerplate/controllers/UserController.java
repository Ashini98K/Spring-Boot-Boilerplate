package com.sample.boilerplate.controllers;

import com.sample.boilerplate.dtos.UserDTO;
import com.sample.boilerplate.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User controller to handle user routes
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

    /**
     * UserService reference object
     */
    private final UserService userService;

    /**
     * Default constructor
     * @param {UserService} userService
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get route for getting all the users
     * @return {ResponseEntity} - List of user DTOs
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }
}
