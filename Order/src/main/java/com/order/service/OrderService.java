package com.order.service;

import com.order.model.Order;

import java.util.List;

public interface OrderService {

    Order create(Order order);

    Order getById(Long id);

    List<Order> getByUserId(Long userId);
}
