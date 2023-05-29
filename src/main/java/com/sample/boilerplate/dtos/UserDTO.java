package com.sample.boilerplate.dtos;

import com.sample.boilerplate.configs.Constants.USER_TYPES;
import com.sample.boilerplate.models.UserModel;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Data transfer object for User model
 */
@Getter
@Setter
public class UserDTO {

    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private USER_TYPES userType;

    public UserModel orElseThrow() {
        return null;
    }
}
