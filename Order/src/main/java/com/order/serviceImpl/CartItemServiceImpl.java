package com.order.serviceImpl;

import com.order.model.CartItem;
import com.order.repository.CartItemRepository;
import com.order.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository repository;

    public CartItem create(CartItem cartItem) {
        return repository.save(cartItem);
    }

    public CartItem update(Long id, CartItem cartItem) {
        CartItem existing = repository.findById(id).orElseThrow();
        existing.setQuantity(cartItem.getQuantity());
        existing.setPrice(cartItem.getPrice());
        existing.setDiscount(cartItem.getDiscount());
        existing.setSubTotal(cartItem.getSubTotal());
        existing.setActive(cartItem.isActive());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<CartItem> getByCartId(Long cartId) {
        return repository.findByCartId(cartId);
    }

    public List<CartItem> getByActive(boolean active) {
        return repository.findByActive(active);
    }

    public void clearCart(Long cartId) {
        repository.deleteByCartId(cartId);
    }
}
