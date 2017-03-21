package com.example;

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

    @RequestMapping("/lots")
    public List<Lot> getAllTopics(){
        return lotService.getAllLots();
    }

    @RequestMapping("/lots/{id}")
    public Lot getLot(@PathVariable String id){
        return lotService.getLot(id);
    }

    @RequestMapping(method= RequestMethod.POST, value = "/lots")
    public void addLot(@RequestBody Lot lot ){
        lotService.addLot(lot);
    }


    @RequestMapping(method= RequestMethod.PUT, value = "/lots/{id}")
    public void updateLot(@RequestBody Lot lot, @PathVariable String id){
        lotService.updateLot(id, lot);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/lotcs/{id}")
    public void  deleteLot(@PathVariable String id){
        lotService.deleteLot(id);
    }

}
