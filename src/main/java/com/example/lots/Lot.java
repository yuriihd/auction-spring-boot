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
    private double price;
    private String endDate;

    private boolean isReadyToBid = true;

    @ManyToOne
    private User seller;


    @ManyToOne
    private User buyer;

    public boolean isReadyToBid() {
        return isReadyToBid;
    }

    public void setReadyToBid(boolean readyToBid) {
        isReadyToBid = readyToBid;
    }

    public String getId() {
        return id;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public User getSeller() {
        return seller;
    }

    public void setSeller(User user) {
        this.seller = user;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Lot(String id, String name, String description, double price, String endDate,  String sellerName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.endDate = endDate;
        this.seller=new User(sellerName,"","", "",0);
        this.buyer = new User("","","", "",0);
    }
    public Lot(){}


}
