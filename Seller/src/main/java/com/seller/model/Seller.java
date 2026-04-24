package com.seller.model;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;

    private String sellerName;
    private String email;
    private Long phoneNumber;
    private String businessName;
    private String businessType;
    private String businessRegistration;
    private String businessPan;
    private String bankDetails;

    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDate updatedDate;

    private String gstNumber;

    
    private Long addressId;

   
    @Transient
    private Address address;
}