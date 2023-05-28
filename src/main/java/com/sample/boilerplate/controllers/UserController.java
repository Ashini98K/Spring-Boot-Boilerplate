package com.sample.boilerplate.controllers;
//
import jakarta.validation.Valid;
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
     * */
    @PostMapping
    public ResponseEntity<Long> addUser (@RequestBody @Valid final UserDTO userDTO){
        final Long userId = userService.addUser(userDTO);
        return new ResponseEntity<>(userId, HttpStatus.CREATED);
    }

    /**
     * Get route for getting all the users
     * @return {ResponseEntity} - List of user DTOs
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    /**
     * Get route for getting a user by id
     * @param {Long} id - Id of the user
     * @return {ResponseEntity} - User DTO
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable final Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    /**
     * Get route for getting a user by email
     * @param {String} email - Email of the user
     * @return {ResponseEntity} - User DTO
     */
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable final String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
}
