package com.seller.service;


import com.seller.model.Seller;

import java.util.List;

public interface SellerService {
    public List<Seller> getAllSeller();

    public Seller getSellerById(Long sellerId);

    public Seller saveSeller(Seller seller);

    public Seller updateService(Long sellerId, Seller seller);

    public boolean deleteSeller(Long sellerId);
}
