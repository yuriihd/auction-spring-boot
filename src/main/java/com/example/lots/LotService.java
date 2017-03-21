package com.example.lots;

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
/*public List<Course> getAllCourses(String topicId){

        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;

    }*/

    public List<Lot> getAllLots(String username){

        List<Lot> lots = new ArrayList<>();
        lotRepository.findByUserUsername(username)
                .forEach(lots::add);
        return lots;

    }


    public Lot getLot(String id){

        return lotRepository.findOne(id);
    }

    public void addLot(Lot lot) {

        lotRepository.save(lot);
    }

    public void updateLot(Lot lot) {
        lotRepository.save(lot );
    }


    public void deleteLot(String id) {
        lotRepository.delete(id);
    }

}
