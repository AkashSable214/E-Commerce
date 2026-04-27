package com.order.service;

import com.order.model.Cart;

public interface CartService {

    Cart create(Cart cart);

    void delete(Long id);

    Cart getById(Long id);

    Cart getByUserId(Long userId);
}
