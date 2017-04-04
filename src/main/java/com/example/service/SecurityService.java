package com.example.service;

import com.example.model.User;

/**
 * Created by Yurii on 04.04.2017.
 */


public interface SecurityService {

    void autologin(String username, String password);

    boolean loginUser(String username, String password);

    User getAuthenticatedUser();

}