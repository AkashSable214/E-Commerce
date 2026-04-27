package com.order.controller;

import com.order.model.OrderItem;
import com.order.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderItemApi/v1")
@CrossOrigin
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    @GetMapping("/{id}")
    public OrderItem getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/order/{orderId}")
    public List<OrderItem> getByOrderId(@PathVariable Long orderId) {
        return service.getByOrderId(orderId);
    }

    @GetMapping("/name/{name}")
    public List<OrderItem> getByName(@PathVariable String name) {
        return service.getByProductName(name);
    }

    @PostMapping("/checkout/{cartId}/{orderId}")
    public String checkout(@PathVariable Long cartId,
                           @PathVariable Long orderId) {

        service.checkout(cartId, orderId);
        return "Order placed successfully";
    }
}
