package com.example.purchases;

import com.example.lots.Lot;
import com.example.users.User;
import com.example.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yurii on 26.03.2017.
 */
@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Purchase> getBuyerPurchases(String username){

        List<Purchase> purchases = new ArrayList<>();
        purchaseRepository.findByBuyerUsername(username)
                .forEach(purchases::add);
        return purchases;
    }


    public void paymentPurchase(String username, String idPurchase){
        Purchase tempPurchase = purchaseRepository.findOne(idPurchase);
        if(tempPurchase.isPurchasePaid()==false) {
            User tempBuyerUser = userRepository.findOne(tempPurchase.getBuyer().getUsername());
            if (tempBuyerUser.getBalance() >= tempPurchase.getPrice()) {
                tempBuyerUser.subtractMoney(tempPurchase.getPrice());
                userRepository.save(tempBuyerUser);
                User tempSellerUser = userRepository.findOne(tempPurchase.getSeller().getUsername());
                tempSellerUser.addMoney(tempPurchase.getPrice());
                userRepository.save(tempSellerUser);
            }
            tempPurchase.setPurchasePaid(true);
        }
    }


    public List<Purchase> getSellerPurchases(String username){

        List<Purchase> purchases = new ArrayList<>();
        purchaseRepository.findBySellerUsername(username)
                .forEach(purchases::add);
        return purchases;
    }
}
