package com.register.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class UserInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userInvoiceId;

    private Long userId;

    private Long invoiceId;

    private Long invoiceNumber;

    private String paymentStatus;

    private Double amount;

    private LocalDate invoiceDate;

    @Lob
    @Column(name = "invoice_pdf", columnDefinition = "LONGBLOB")
    private byte[] invoicePdf;

}