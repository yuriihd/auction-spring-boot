package com.example.users;


import com.example.lots.Lot;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Yurii on 21.03.2017.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
