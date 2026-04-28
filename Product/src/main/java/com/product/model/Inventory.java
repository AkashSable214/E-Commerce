package com.product.model;

import java.time.LocalDate;

import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocalDate lastUpdated;

    private Long supplierId;
    private double costPrice;
    private Boolean status;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
