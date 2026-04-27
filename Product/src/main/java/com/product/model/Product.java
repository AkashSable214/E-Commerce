package com.product.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productname;
    private String description;
    private double price;
    private double discountPrice;
    private String brand;
    private String sku;
    private double weight;
    private String dimensions;
    private String color;
    private String size;
    private double rating;
    private int reviewCount;

    @Lob
    private Byte[] image;

    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDate updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Review> reviews;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Inventory inventory;

    //@OneToOne
    //private Seller seller;

    //@OneToOne
    //private Admin admin;

    //OnetoMany
    //List<CartItem> cartItem

    //@OnetoMany
   // private List<OrderItem> orderItem


}
