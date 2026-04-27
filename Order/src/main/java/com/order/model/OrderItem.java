package com.order.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    private String productName;
    private double price;
    private int quantity;
    private double discount;
    private double tax;
    private double subTotal;
    private String status;

@CreatedDate
private Date createdDate;

    private Long orderId;
    private Long productId;

    @OneToOne(mappedBy = "orderItem", cascade = CascadeType.ALL)
    private Order order;

//    @OneToOne(mappedBy = "orderItem", cascade = CascadeType.ALL)
//    private Product product;
}
