package com.order.repository;

import com.order.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCartIdAndActive(Long cartId, boolean active);

    List<CartItem> findByCartId(Long cartId);

    List<CartItem> findByActive(boolean active);

    void deleteByCartId(Long cartId);
}
