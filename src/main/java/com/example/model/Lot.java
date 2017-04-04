package com.example.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Yurii on 21.03.2017.
 */

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lot {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String topic;
    private String description;
    private double price;
    private String endDate;


    @ManyToOne
    private User seller;


    @ManyToOne
    private User buyer;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    public String getEndDate() {
        return endDate;
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

    public String getTopic() {
        return topic;
    }


    public boolean hasBuyer(){
        if(this.buyer!=null)
            return true;
        else return false;
    }

}
