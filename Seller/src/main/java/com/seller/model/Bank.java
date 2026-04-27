package com.seller.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;

    private String bankName;
    private String bankIFSCCode;
    private String bankAccountNumber;
    private String bankAccountName;
    private String bankAccountType;
    private String bankBranch;

    @OneToMany(mappedBy = "bankDetails", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Seller> sellers;


}
