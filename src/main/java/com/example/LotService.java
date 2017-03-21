package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yurii on 21.03.2017.
 */
@Service
public class LotService {
    @Autowired
    private LotRepository lotRepository;


    public List<Lot> getAllLots(){

        List<Lot> lots = new ArrayList<>();
        lotRepository.findAll()
                .forEach(lots::add);
        return lots;

    }


    public Lot getLot(String id){

        return lotRepository.findOne(id);
    }

    public void addLot(Lot lot) {

        lotRepository.save(lot);
    }

    public void updateLot(String id, Lot lot) {
        lotRepository.save(lot );
    }


    public void deleteLot(String id) {
        lotRepository.delete(id);
    }

}
