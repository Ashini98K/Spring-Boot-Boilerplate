package com.sample.boilerplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <T, ID> extends JpaRepository<T, ID>{
}
