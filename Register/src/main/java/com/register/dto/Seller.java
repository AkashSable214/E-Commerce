package com.register.dto;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public class Seller {
	
	 private Long sellerId;

	    private String sellerName;
	    private String email;
	    private Long phoneNumber;
	    private String businessName;
	    private String businessType;
	    private String businessRegistration;
	    private String businessPan;
	    private LocalDate createdDate;
	    private LocalDate updatedDate;

	    private String gstNumber;

	    

}
