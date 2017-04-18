package com.example.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Yurii on 21.03.2017.
 */

@Entity
@Data
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

    public boolean hasBuyer(){
        if(this.buyer!=null)
            return true;
        else return false;
    }

}
