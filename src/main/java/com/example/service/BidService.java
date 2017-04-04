package com.example.service;

import com.example.model.Lot;
import com.example.repository.LotRepository;
import com.example.model.User;
import com.example.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;


    public List<Lot> getAllBids(String username){
        List<Lot> lots = new ArrayList<>();
        lotRepository.findByBuyerUsername(username)
                .forEach(lots::add);
        return lots;
    }

    public void addBid(Lot lot, String username, double amount) {

        Lot tempLot = lotRepository.findById(lot.getId());
        User user = userRepository.findOne(username);
        if(user.getPenalty()==0 && tempLot.getPrice()< amount ) {
            tempLot.setPrice(amount);
            lot.setSeller(lotRepository.findById(lot.getId()).getSeller());
            lot.setBuyer(new User(username,"", "", "", "", 0));
            lotRepository.save(lot);
        }

    }

    public Lot  getBid(String id){

        return lotRepository.findOne(id);
    }

    public void updateBid(Lot lot,  double amount) {

        Lot tempLot = lotRepository.findById(lot.getId());
        if(tempLot.getPrice()< amount ) {
            tempLot.setPrice(amount);
            lot.setSeller(tempLot.getSeller());
            lot.setBuyer(tempLot.getBuyer());
            lotRepository.save(lot);
        }
    }



}
