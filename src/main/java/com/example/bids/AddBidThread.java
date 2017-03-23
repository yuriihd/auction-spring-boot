package com.example.bids;

import com.example.lots.Lot;
import com.example.lots.LotRepository;
import com.example.users.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Yurii on 23.03.2017.
 */

public class AddBidThread implements  Runnable{

    private Lot lot;
    private String username;
    private double amount;
    private LotRepository lotRepository;



    public AddBidThread(Lot lot, String username, double amount, LotRepository lotRepository) {
        this.lot = lot;
        this.username = username;
        this.amount = amount;
        this.lotRepository=lotRepository;
    }

    public AddBidThread(){}



    public synchronized void run(){
        Lot tempLot = lotRepository.findOne(lot.getId());
        while(tempLot.isReadyToBid() == false)
           try{ wait();}
           catch (InterruptedException e) {}
        tempLot.setReadyToBid(false);
        if(tempLot.getPrice()< amount ) {
            tempLot.setPrice(amount);
            lot.setSeller(lotRepository.findOne(lot.getId()).getSeller());
            lot.setBuyer(new User(username, "", "", "", 0));
            lot.setReadyToBid(true);
            lotRepository.save(lot);
        }
        else
            tempLot.setReadyToBid(true);
        notify();
    }
}
