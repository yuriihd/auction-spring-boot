package com.example.comments;

import com.example.users.User;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yurii on 26.03.2017.
 */

@Entity
public class Comment {

    public String description;
    public String dateTime;
    @Id
    public String id;

    @ManyToOne
    public User fromWhom;

    @ManyToOne
    public User toWhom;


    public Comment(){

    }
    public Comment(String decription, User fromWhom, User toWhom) {

        Date curTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        this.dateTime = sdf.format(curTime);

        this.description = description;
        this.fromWhom = fromWhom;
        this.toWhom = toWhom;
        String id = dateTime+fromWhom.getUsername()+toWhom.getUsername();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
