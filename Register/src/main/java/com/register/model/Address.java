package com.register.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.CascadeType.ALL;

@Entity
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
