package com.example.lots;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Yurii on 21.03.2017.
 */
public interface LotRepository extends CrudRepository<Lot, String> {
    public List<Lot> findBySellerUsername (String username);
    public List<Lot> findByBuyerUsername (String username);
}
