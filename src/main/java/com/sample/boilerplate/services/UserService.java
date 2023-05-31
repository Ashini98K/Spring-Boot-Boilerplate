package com.sample.boilerplate.services;
//

import com.sample.boilerplate.exceptions.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
//
import com.sample.boilerplate.dtos.UserDTO;
import com.sample.boilerplate.models.UserModel;
import com.sample.boilerplate.repositories.UserRepository;

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
     * Add user to database
     * @param {UserDTO} userDTO
     * @return {userId} - ID of the user that is created
     */
    public Long addUser(final UserDTO userDTO) {
        final UserModel user = new UserModel();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getId();
    }

    /**
     * Get all users, transfer them into user DTOs and return it as a list
     * @param {int} page - Page number
     * @param {int} pageSize - Page size
     * @param {String} sortBy - Attribute to sort by
     * @param {Sort.Direction} sortDirection - Sorting direction
     * @return {List<UserDTO>} - List of user DTOs
     */
    public Page<UserDTO> findAll(int page, int pageSize, String sortBy, Sort.Direction sortDirection) {
        final Sort sort = Sort.by(sortDirection, sortBy);
        final Pageable pageable = PageRequest.of(page, pageSize, sort);
        final Page<UserModel> users = userRepository.findAll(pageable);
        return users.map(user -> {
            final UserDTO userDTO = new UserDTO();
            mapToUserDTO(user, userDTO);
            return userDTO;
        });
    }

    /**
     * Method to get user by id
     * @param {Long} id - ID of the user that needs to be fetched
     * @return {UserDTO} userDTO - User DTO object
     */
    public UserDTO getUserById(Long id) {
        final UserModel user = userRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("No user found for the given ID"));
        final UserDTO userDTO = new UserDTO();
        return mapToUserDTO(user, userDTO);
    }

    /**
     * Method to get user by email
     * @param {String} email - Email of the user that needs to be fetched
     * @return {UserDTO} userDTO - User DTO object
     */
    public UserDTO getUserByEmail(String email) {
        final UserModel user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RecordNotFoundException("No user found for the given email");
        }
        final UserDTO userDTO = new UserDTO();
        return mapToUserDTO(user, userDTO);
    }

    /**
     * Method to transfer user DTO into a user Model
     * @param {UserModel} userModel - User model object that needs to be converted into a user DTO
     * @param {UserDTO} userDTO - User DTO object that needs to be converted into a user model
     * @return {UserModel} userModel - Converted user model object
     */
    private UserModel mapToEntity(UserDTO userDTO, UserModel userModel) {
        userModel.setFirstName(userDTO.getFirstName());
        userModel.setLastName(userDTO.getLastName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setUserType(userDTO.getUserType());
        return userModel;
    }

    /**
     * Method to transfer user model into a user DTO
     * @param {UserModel} user - User model object that needs to be converted into a user DTO
     * @return {UserDTO} userDTO - Converted user DTO
     */
    private UserDTO mapToUserDTO(UserModel user, UserDTO userDTO) {
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserType(user.getUserType());
        return userDTO;
    }

}
