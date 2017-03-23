package com.example.bids;

import com.example.lots.Lot;
import com.example.lots.LotRepository;
import com.example.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yurii on 22.03.2017.
 */
@Service
public class BidService {
    @Autowired
    private LotRepository lotRepository;


    public List<Lot> getAllBids(String username){
        List<Lot> lots = new ArrayList<>();
        lotRepository.findByBuyerUsername(username)
                .forEach(lots::add);
        return lots;
    }

    public void addBid(Lot lot, String username, double amount) {
        (new Thread(new AddBidThread(lot,username,amount,this.lotRepository))).start();

    }

    public Lot  getBid(String id){

        return lotRepository.findOne(id);
    }

    public void updateBid(Lot lot,  double amount) {
        if(lotRepository.findOne(lot.getId()).getPrice()< amount ) {
            lotRepository.findOne(lot.getId()).setPrice(amount);
            lot.setSeller(lotRepository.findOne(lot.getId()).getSeller());
            lot.setBuyer(lotRepository.findOne(lot.getId()).getBuyer());
            lotRepository.save(lot);
        }
    }



}
