package com.sample.boilerplate.services;

import com.sample.boilerplate.dtos.UserDTO;
import com.sample.boilerplate.models.UserModel;
import com.sample.boilerplate.repositories.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service file that has user domain related business logics
 */
@Service
public class UserService {
    /**
     * UserRepository reference object
     */
    private final UserRepository userRepository;

    /**
     * Default constructor
     * @param {UserService} userRepository
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Get all users, transfer them into user DTOs and return it as a list
     * @return {List<UserDTO>} - List of user DTOs
     */
    public List<UserDTO> findAll() {
        final List<UserModel> users = userRepository.findAll(Sort.by("id"));
        return users.stream()
                .map((user) -> mapToUserDTO(user))
                .toList();
    }

    /**
     * Method to transfer user model into a user DTO
     * @param {UserModel} user
     * @return
     */
    private UserDTO mapToUserDTO(UserModel user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserType(user.getUserType());
        return userDTO;
    }
}
