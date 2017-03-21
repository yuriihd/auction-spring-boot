package com.example.users;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Yurii on 21.03.2017.
 */
@Entity
public class User {

    @Id
    private String username;
    private String name;
    private String surname;
    private String email;
    private double balance;

    public User(String username, String name, String surname, String email, double balance) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.balance = balance;
    }
    public User(){}
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
