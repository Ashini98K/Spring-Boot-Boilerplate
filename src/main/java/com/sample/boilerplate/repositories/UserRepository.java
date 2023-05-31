package com.sample.boilerplate.repositories;

import com.sample.boilerplate.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * User repository interface that has base repository functionalities and user domain specific functionalities
 */
@Repository
public interface UserRepository extends BaseRepository<UserModel, Long> {
    /**
     * Find all users
     * @param {Pageable} pageable - The pageable to request a paged result
     * @return {Page<UserModel>} - Page of user models
     */
    Page<UserModel> findAll(Pageable pageable);
}
