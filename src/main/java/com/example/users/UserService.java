package com.example.users;

import com.example.lots.Lot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yurii on 21.03.2017.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers(){

        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;

    }


    public User getUser(String username){

        return userRepository.findOne(username);
    }

    public void addUser(User user) {

        userRepository.save(user);
    }

    public void updateUser(String username, User user) {
        userRepository.save(user);
    }


    public void deleteUser(String username) {
        userRepository.delete(username);
    }

}
