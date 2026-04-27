package com.order.serviceImpl;

import com.order.model.Order;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    public Order create(Order order) {
        order.setCreatedDate(new Date());
        order.setStatus("CREATED");
        return repository.save(order);
    }

    public Order getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Order> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
