package com.example.purchases;

import com.example.lots.Lot;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    private User seller;

    @ManyToOne
    private User buyer;




    public long getId() {
        return id;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
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

    public Purchase(){}

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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean hasBuyer(){
        if(this.buyer!=null)
            return true;
        else return false;
    }

}
