package com.sample.boilerplate.repositories;

import com.sample.boilerplate.models.UserModel;
import org.springframework.stereotype.Repository;

/**
 * User repository interface that has base repository functionalities and user domain specific functionalities
 */
@Repository
public interface UserRepository extends BaseRepository<UserModel, Long> {

    /**
     * Find user by email
     *
     * @param {String} email - Email of the user
     * @return {List<UserModel>} - List of user models
     */
    UserModel findByEmail(String email);
}
