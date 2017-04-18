package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Yurii on 21.03.2017.
 */

@Entity
@Data
@NoArgsConstructor
public class Purchase {
    @Id
    private long id;
    private String name;
    private String topic;
    private String description;
    private double price;
    private String endDate;
    private String purchaseDate;
    private String status = "NOT PAID";

    @ManyToOne
    private User seller;

    @ManyToOne
    private User buyer;

    public Purchase(Lot lot){
        this.id = lot.getId();
        this.name = lot.getName();
        this.description = lot.getDescription();
        this.price = lot.getPrice();
        this.endDate = lot.getEndDate();
        this.seller=lot.getSeller();
        this.buyer = lot.getBuyer();
        this.topic = lot.getTopic();

    }

    public Purchase(long id, String name, String description, double price, String endDate,  String sellerName, String topic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.endDate = endDate;
        this.seller=new User(sellerName,"", "","", "",0);
        this.buyer = new User("","", "","", "",0);
        this.topic = topic;
    }

    public boolean hasBuyer(){
        if(this.buyer!=null)
            return true;
        else return false;
    }

}
