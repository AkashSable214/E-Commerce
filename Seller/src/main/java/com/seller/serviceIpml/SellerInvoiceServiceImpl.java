package com.seller.serviceIpml;

import com.seller.model.SellerInvoice;
import com.seller.repository.SellerInvoiceRepository;
import com.seller.service.SellerInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerInvoiceServiceImpl implements SellerInvoiceService {

    private final SellerInvoiceRepository sellerInvoiceRepository;

    @Override
    public void saveSellerInvoice(SellerInvoice invoice) {
        sellerInvoiceRepository.save(invoice);
    }
    
    
}
