package com.order.serviceImpl;

import com.order.model.Cart;
import com.order.repository.CartRepository;
import com.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository repository;

    public Cart create(Cart cart) {
        return repository.save(cart);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Cart getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Cart getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
