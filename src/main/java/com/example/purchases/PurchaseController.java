package com.example.purchases;

import com.example.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yurii on 26.03.2017.
 */
@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @RequestMapping("/users/{username}/purchases")
    public List<Purchase> getAllPurchases(@PathVariable String username){
        return  purchaseService.getBuyerPurchases(username);
    }


    @RequestMapping("/users/{username}/purchases/{idPurchases}/payment")
    public void paymentPurchase(@PathVariable String username,@PathVariable String idPurchases ){

        purchaseService.paymentPurchase(username,idPurchases);

    }

//    @RequestMapping("/users/{username}")
//    public User getUser(@PathVariable String username){
//        return  userService.getUser(username);
//    }








}
