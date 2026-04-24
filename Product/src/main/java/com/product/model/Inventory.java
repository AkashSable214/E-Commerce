package com.product.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    private int stackQuantity;
    private int reservedQuantity;
    private String wareHouseLocation;
    private int reOrderLevel;

    @LastModifiedDate
    private Date lastUpdated;

    private Long supplierId;
    private double costPrice;
    private Boolean status;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
