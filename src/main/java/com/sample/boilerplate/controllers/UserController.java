package com.sample.boilerplate.controllers;
//

import com.sample.boilerplate.configs.Constants;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
import com.sample.boilerplate.dtos.UserDTO;
import com.sample.boilerplate.services.UserService;

/**
 * User controller to handle user routes
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
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
     * POST route for adding a user
     * @return {userId}
     */
    @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User details", content = @Content(examples = @ExampleObject(value = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\",\"userType\":\"INTERNAL\"}")))
    @PostMapping
    public ResponseEntity<Long> addUser(@RequestBody @Valid final UserDTO userDTO) {
        final Long userId = userService.addUser(userDTO);
        return new ResponseEntity<>(userId, HttpStatus.CREATED);
    }

    /**
     * Get route for getting all the users
     * @param {int} page - Page number
     * @param {int} pageSize - Page size
     * @param {String} sortBy - Attribute to sort by
     * @param {Sort.Direction} sortDirection - Sorting direction
     * @return {ResponseEntity} - List of user DTOs
     */
    @GetMapping
    public ResponseEntity<Page<UserDTO>> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection) {
        return ResponseEntity.ok(userService.findAll(page, pageSize, sortBy, sortDirection));
    }

    /**
     * Get route for getting a user by id
     * @param {Long} id - ID of the user
     * @return {ResponseEntity} - User DTO
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable final Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    /**
     * Patch route for deleting a user by user ID
     * @param {Long} id - ID of the user
     * @param {UserDTO} userDTO - User object that is used to patch the resource
     * @return {ResponseEntity} - User DTO
     */
    @PatchMapping(path = "/{id}")
    public ResponseEntity<UserDTO> patchUserById(@PathVariable final Long id, @RequestBody @Valid final UserDTO userDTO) {
        return ResponseEntity.ok(userService.patchUserById(id, userDTO));
    }

    /**
     * Delete route for deleting a user by user ID
     * @param {Long} id - ID of the user
     * @return {ResponseEntity} - User DTO
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UserDTO> deleteUserById(@PathVariable final Long id) {
        return ResponseEntity.ok(userService.deleteUserById(id));
    }
}
