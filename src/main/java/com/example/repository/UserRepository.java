package com.example.repository;

import com.example.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yurii on 21.03.2017.
 */
public interface UserRepository extends CrudRepository<User, String> {
    public User findByUsername(String email);
}
