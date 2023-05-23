package com.sample.boilerplate.repositories;

import com.sample.boilerplate.models.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserModel, Long> {
}
