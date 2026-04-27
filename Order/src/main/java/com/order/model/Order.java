package com.order.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String orderNumber;

@CreatedDate
private Date orderDate;

    private Boolean orderStatus;

    private double totalAmount;
    private double discountAmount;
    private double finalAmount;

    private String paymentStatus;

@CreatedDate
private Date createdDate;

@LastModifiedDate
private Date updatedDate;

    private double taxAmount;
    private double shippingAmount;

 @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
 private User user;

 @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
 private Admin admin;

 @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
 private Payment payment;

 @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
 private Address address;

 @OneToMany
 @JoinColumn(name = "order_id")
 @JsonManagedReference
 private List<Product> product;
}
