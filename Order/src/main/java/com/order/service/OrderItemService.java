package com.order.service;

import com.order.model.OrderItem;

import java.util.List;

public interface OrderItemService {

    void checkout(Long cartId, Long orderId);

    OrderItem getById(Long id);

    List<OrderItem> getByOrderId(Long orderId);

    List<OrderItem> getByProductName(String name);
}
