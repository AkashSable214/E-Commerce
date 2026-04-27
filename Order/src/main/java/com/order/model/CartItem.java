package com.order.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    private int quantity;
    private double price;
    private double discount;
    private double subTotal;

@CreatedDate
private Date createdDate;

@LastModifiedDate
private Date updatedDate;

    private boolean active;

    private Long cartId;
    private Long productId;

//    @OneToOne(mappedBy = "cartItem", cascade = CascadeType.ALL)
//    private Product product;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
