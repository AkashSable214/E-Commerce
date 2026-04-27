package com.order.service;

import com.order.model.CartItem;

import java.util.List;

public interface CartItemService {

    CartItem create(CartItem cartItem);

    CartItem update(Long id, CartItem cartItem);

    void delete(Long id);

    List<CartItem> getByCartId(Long cartId);

    List<CartItem> getByActive(boolean active);

    void clearCart(Long cartId);
}
