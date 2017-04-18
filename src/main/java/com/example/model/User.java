package com.example.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Yurii on 21.03.2017.
 */
@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long Id;

    @Size(min=3, max=20,
            message="Username must be between 3 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z0-9]+$",
            message="Username must be alphanumeric with no spaces")
    private String username;
    @Size(min=6, max=20,
            message="The password must be at least 6 characters long.")
    private String password;

    private String name;
    private String surname;
    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message="Invalid email address.")
    private String email;
    private double balance;
    private double penalty = 0;// 20% from unpaid lot

    public User(String username, String password, String name, String surname, String email, double balance) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.balance = balance;
    }



    public void addPenalty(double penalty) {
        this.penalty += penalty;
    }


    public void addMoney(double amount) {
        this.balance +=amount;
    }

    public void subtractMoney(double amount) {
        this.balance -= amount;
    }


}
