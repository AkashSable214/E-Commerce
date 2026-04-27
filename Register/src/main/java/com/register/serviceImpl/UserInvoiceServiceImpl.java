package com.register.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.model.UserInvoice;
import com.register.repository.UserInvoiceRepository;
import com.register.service.UserInvoiceService;

@Service
public class UserInvoiceServiceImpl implements UserInvoiceService {

    @Autowired
    private UserInvoiceRepository userInvoiceRepository;
    
   



    @Override
    public void saveInvoice(UserInvoice userInvoice) {

        userInvoiceRepository.save(userInvoice);

    }
}
