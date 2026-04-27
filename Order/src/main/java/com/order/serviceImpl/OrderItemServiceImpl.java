package com.order.serviceImpl;

import com.order.model.CartItem;
import com.order.model.OrderItem;
import com.order.repository.CartItemRepository;
import com.order.repository.OrderItemRepository;
import com.order.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository repository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public OrderItem getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<OrderItem> getByOrderId(Long orderId) {
        return repository.findByOrderId(orderId);
    }

    public List<OrderItem> getByProductName(String name) {
        return repository.findByProductName(name);
    }

    public void checkout(Long cartId, Long orderId) {

        List<CartItem> cartItems = cartItemRepository.findByCartIdAndActive(cartId, true);

        for (CartItem item : cartItems) {

            OrderItem orderItem = new OrderItem();

            orderItem.setProductId(item.getProductId());
            orderItem.setProductName("Product");
            orderItem.setPrice(item.getPrice());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setDiscount(item.getDiscount());
            orderItem.setTax(0);
            orderItem.setSubTotal(item.getSubTotal());
            orderItem.setStatus("PLACED");
            orderItem.setOrderId(orderId);
            orderItem.setCreatedDate(new Date());

            repository.save(orderItem);
        }

        for (CartItem item : cartItems) {
            item.setActive(false);
        }

        cartItemRepository.saveAll(cartItems);
    }
}
