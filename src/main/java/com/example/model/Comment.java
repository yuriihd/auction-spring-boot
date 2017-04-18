package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Yurii on 26.03.2017.
 */

@Entity
@Data
@NoArgsConstructor
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


    public Comment(String description, User fromWhom, User toWhom) {

        Date curTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        this.dateTime = sdf.format(curTime);
        this.description = description;
        this.fromWhom = fromWhom;
        this.toWhom = toWhom;
        this.id = 1l;
    }
}
