package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Yurii on 21.03.2017.
 */

@Entity
public class Lot {
    @Id
    private String id;
    private String name;
    private String description;
    private double startPrice;
    private String endDate;

    public Lot(String id, String name, String description, double startPrice, String endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startPrice = startPrice;
        this.endDate = endDate;
    }

    public Lot(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndTime(String endDate) {
        this.endDate = endDate;
    }

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

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }
}
