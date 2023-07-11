package com.javaweb.demo.dao;

import com.javaweb.demo.entity.Book;
import com.javaweb.demo.entity.Purchase;

import java.util.List;

public interface PurchaseDao {
    //public boolean addPurchase(Purchase purchase);
    //public boolean deletePurchase(String bno) ;
    // public boolean updatePurchase(Purchase purchase) ;
    public List<Purchase> getAllPurchase();
}
