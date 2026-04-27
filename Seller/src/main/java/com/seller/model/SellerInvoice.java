package com.seller.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class SellerInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sellerId;

    private Long invoiceId;

    private Long invoiceNumber;

    private Double amount;

    private String paymentStatus;

    private LocalDate invoiceDate;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] invoicePdf;
}