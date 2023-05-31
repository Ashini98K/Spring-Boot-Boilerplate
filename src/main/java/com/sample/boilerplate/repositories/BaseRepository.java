package com.sample.boilerplate.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Base repository interface that extends JPA repository that has all generic database functionalities
 * @param <T> Model class
 * @param <ID> Primary key
 */
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
    /**
     * Find all method
     * @param {Pageable} - Pageable the pageable to request a paged result
     * @return {Page<UserModel>} - Page of <T> models
     */
    Page<T> findAll(Pageable pageable);
}
