package com.register.model;

import static jakarta.persistence.CascadeType.ALL;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Table(name="SellerAddress")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String landmark;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String addressType;

    @ManyToOne(fetch = FetchType.LAZY,cascade = ALL)
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;
    
   
    
    
}
