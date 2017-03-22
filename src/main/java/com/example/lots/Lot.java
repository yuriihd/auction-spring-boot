package com.example.lots;

import com.example.users.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Yurii on 21.03.2017.
 */

@Entity
@Data
public class Lot {
    @Id
    private String id;
    private String name;
    private String description;
    private double startPrice;
    private String endDate;

    @ManyToOne
    private User seller;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User user) {
        this.seller = user;
    }

    public Lot(String id, String name, String description, double startPrice, String endDate, String username) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startPrice = startPrice;
        this.endDate = endDate;
        this.seller=new User(username,"","", "",0);



    }
    public Lot(){}


}
