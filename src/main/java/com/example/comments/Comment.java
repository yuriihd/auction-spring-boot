package com.example.comments;

import com.example.users.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yurii on 26.03.2017.
 */

@Entity
public class Comment {

    @Id
    @GeneratedValue
    public Long id;

    public String description;
    public String dateTime;

    @ManyToOne
    public User fromWhom =new  User();

    @ManyToOne
    public User toWhom = new User();


    public Comment(){

    }
    public Comment(String description, User fromWhom, User toWhom) {

        Date curTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        this.dateTime = sdf.format(curTime);
        this.description = description;
        this.fromWhom = fromWhom;
        this.toWhom = toWhom;
        this.id = 1l;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public User getFromWhom() {
        return fromWhom;
    }

    public void setFromWhom(User fromWhom) {
        this.fromWhom = fromWhom;
    }

    public User getToWhom() {
        return toWhom;
    }

    public void setToWhom(User toWhom) {
        this.toWhom = toWhom;
    }
}
