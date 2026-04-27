package com.product.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date updatedDate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Inventory inventory;
}
