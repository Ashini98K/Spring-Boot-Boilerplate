package com.sample.boilerplate.services;

import com.sample.boilerplate.dtos.UserDTO;
import com.sample.boilerplate.models.UserModel;
import com.sample.boilerplate.repositories.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        final List<UserModel> users = userRepository.findAll(Sort.by("id"));
        return users.stream()
                .map((user) -> mapToUserDTO(user))
                .toList();
    }

    private UserDTO mapToUserDTO(UserModel user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserType(user.getUserType());
        return userDTO;
    }
}
