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

    @ManyToOne
    private User seller;


    @ManyToOne
    private User buyer;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
