package com.example.lots;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    public Lot(String id, String name, String description, double startPrice, String endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startPrice = startPrice;
        this.endDate = endDate;
    }
    public Lot(){}


}
