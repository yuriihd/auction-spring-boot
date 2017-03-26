package com.example.purchases;


import com.example.lots.Lot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Yurii on 26.03.2017.
 */
public interface PurchaseRepository extends CrudRepository<Purchase, String> {
    public List<Purchase> findBySellerUsername (String username);
    public List<Purchase> findByBuyerUsername (String username);
    public List<Purchase> findByPurchaseDate (String username);
}
