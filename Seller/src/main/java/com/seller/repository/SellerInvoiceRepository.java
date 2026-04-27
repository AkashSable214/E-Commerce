package com.seller.repository;

import com.seller.model.SellerInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerInvoiceRepository extends JpaRepository<SellerInvoice, Long> {
}
