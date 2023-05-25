package com.sample.boilerplate.dtos;

import com.sample.boilerplate.configs.Constants.USER_TYPES;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Data transfer object for User model
 */
@Getter
@Setter
public class UserDTO {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private USER_TYPES userType;
}
