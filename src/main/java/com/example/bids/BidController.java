package com.example.bids;

import com.example.lots.Lot;
import com.example.lots.LotService;
import com.example.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yurii on 22.03.2017.
 */

@RestController
public class BidController {

    @Autowired
    private BidService bidService;


    @RequestMapping("/users/{username}/bids")
    public List<Lot> getAllBids(@PathVariable String username){
        return bidService.getAllBids(username);
    }

    @RequestMapping("/users/{username}/bids/{id}")
    public Lot getBid(@PathVariable String id){
        return bidService.getBid(id);
    }

    @RequestMapping(method= RequestMethod.POST, value = "/users/{username}/bids/{amount}")
    public void addBids(@RequestBody Lot lot, @PathVariable String username, @PathVariable double amount){
        bidService.addBid(lot,username,amount);
    }

    @RequestMapping(method= RequestMethod.PUT, value = "/users/{username}/bids/{id}/{amount}")
    public void updateLot(@RequestBody Lot lot, @PathVariable String username,@PathVariable String id, @PathVariable double amount){
        bidService.updateBid(lot,amount);
    }



}
