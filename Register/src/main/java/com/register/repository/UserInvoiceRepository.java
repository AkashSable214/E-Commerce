package com.register.repository;

import com.register.model.UserInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInvoiceRepository extends JpaRepository<UserInvoice,Long> {
}
