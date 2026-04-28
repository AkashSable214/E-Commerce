package com.order.controller;

import com.order.model.CartItem;
import com.order.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartItemApi/v1")
@CrossOrigin
public class CartItemController {

    @Autowired
    private CartItemService service;

    @PostMapping
    public CartItem create(@RequestBody CartItem cartItem) {
        return service.create(cartItem);
    }

    @PutMapping("/{id}")
    public CartItem update(@PathVariable Long id, @RequestBody CartItem cartItem) {
        return service.update(id, cartItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/cart/{cartId}")
    public List<CartItem> getByCartId(@PathVariable Long cartId) {
        return service.getByCartId(cartId);
    }

    @GetMapping("/active/{active}")
    public List<CartItem> getByActive(@PathVariable boolean active) {
        return service.getByActive(active);
    }

    @DeleteMapping("/cart/{cartId}")
    public void clearCart(@PathVariable Long cartId) {
        service.clearCart(cartId);
    }
}
