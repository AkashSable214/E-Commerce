package com.order.controller;

import com.order.model.Cart;
import com.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartApi/v1")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService service;

    @PostMapping
    public Cart create(@RequestBody Cart cart) {
        return service.create(cart);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Cart getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/user/{userId}")
    public Cart getByUserId(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }
}
