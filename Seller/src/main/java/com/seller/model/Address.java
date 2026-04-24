package com.seller.model;

import lombok.Data;

@Data
public class Address {

    private Long addressId;
    private String landmark;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String addressType;
}