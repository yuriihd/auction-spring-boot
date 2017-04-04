package com.example.repository;


import com.example.model.Lot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yurii on 21.03.2017.
 */
public interface LotRepository extends CrudRepository<Lot, String> {

    public List<Lot> findBySellerUsername (String username);
    public List<Lot> findByBuyerUsername (String username);
    public List<Lot> findByTopic (String topic);
    public List<Lot> findByEndDate (String topic);
    public Lot findById (Long Id);

    @Transactional
    Long deleteById(Long firstName);
}
