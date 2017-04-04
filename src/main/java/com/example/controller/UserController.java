package com.example.controller;

import com.example.service.SecurityService;
import com.example.service.UserService;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yurii on 21.03.2017.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;


    /*@RequestMapping(method= RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user ){
         userService.addUser(user);
    }*/


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user){
        userService.addUser(user);
        securityService.autologin(user.getUsername(), user.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody User user){
        boolean ans = securityService.loginUser(user.getUsername(), user.getPassword());
        if (!ans)
            return new ResponseEntity<>("Password incorrect or user does not exist", HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }

    @RequestMapping("/users/{username}")
    public User getUser(@PathVariable String username){
        return  userService.getUser(username);
    }


    @RequestMapping(method= RequestMethod.PUT, value = "/users/{username}")
    public void updateUser(@RequestBody User user, @PathVariable String username){
         userService.updateUser(username, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{username}")
    public void  deleteUser(@PathVariable String username){
         userService.deleteUser(username);
    }

}
