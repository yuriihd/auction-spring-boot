package com.example.users;

import com.example.lots.Lot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yurii on 21.03.2017.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }

    @RequestMapping("/users/{username}")
    public User getUser(@PathVariable String username){
        return  userService.getUser(username);
    }

    @RequestMapping(method= RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user ){
         userService.addUser(user);
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
