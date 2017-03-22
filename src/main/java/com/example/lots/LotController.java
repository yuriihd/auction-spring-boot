package com.example.lots;

import com.example.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yurii on 21.03.2017.
 */
@RestController
public class LotController {

    @Autowired
    private LotService lotService;

    @RequestMapping("/users/{username}/lots")
    public List<Lot> getAllLots(@PathVariable String username){
        return lotService.getAllLots(username);
    }


    @RequestMapping("/users/{username}/lots/{id}")
    public Lot getLot(@PathVariable String id){
        return lotService.getLot(id);
    }

    @RequestMapping(method= RequestMethod.POST, value = "/users/{username}/lots")
    public void addLot(@RequestBody Lot lot, @PathVariable String username){
        lot.setSeller(new User(username,"","", "",0));
        lotService.addLot(lot);
    }


    @RequestMapping(method= RequestMethod.PUT, value = "/users/{username}/lots/{id}")
    public void updateLot(@RequestBody Lot lot, @PathVariable String username,@PathVariable String id){
        lot.setSeller(new User(username,"","", "",0));
        lotService.updateLot(lot);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{username}/lots/{id}")
    public void  deleteLot(@PathVariable String id){
        lotService.deleteLot(id);
    }

}
