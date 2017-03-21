package com.example.users;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Yurii on 21.03.2017.
 */
@Entity
@Data
public class User {

    @Id
    private String username;
    private String name;
    private String surname;
    private String email;
    private double balance;


}
