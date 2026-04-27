package com.seller.controller;

import com.seller.model.Seller;
import com.seller.model.SellerInvoice;
import com.seller.service.SellerInvoiceService;
import com.seller.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/seller/api/v1")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private SellerInvoiceService sellerInvoiceService;

    @GetMapping(value="/getAllSeller")
    public ResponseEntity<List<Seller>> getAllSeller(){

        return new ResponseEntity<>(sellerService.getAllSeller(), HttpStatus.OK);
    }
    @GetMapping(value="/getSeller/{sellerId}")
    public ResponseEntity<Seller> getSellerById(@PathVariable("sellerId") Long sellerId){

        return new ResponseEntity<>(sellerService.getSellerById(sellerId),HttpStatus.OK);
    }

    @PostMapping(value = "/saveSeller")
    public ResponseEntity<Seller> saveSeller(@RequestBody Seller seller){


        return new ResponseEntity<>(sellerService.saveSeller(seller),HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateSeller/{sellerId}")
    public ResponseEntity<Seller> updateSeller(@PathVariable("sellerId") Long sellerId,@RequestBody Seller seller){


        return new ResponseEntity<>(sellerService.updateService(sellerId,seller),HttpStatus.OK);
    }




    @DeleteMapping("/delete/{sellerId}")
    public ResponseEntity<Void> deleteSellerById(@PathVariable Long sellerId) {
        boolean isDeleted = sellerService.deleteSeller(sellerId);

        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }

    @PostMapping("/payment-update")
    public ResponseEntity<String> updateSellerAfterPayment(
            @RequestParam Long invoiceId,
            @RequestBody byte[] pdf) {

        SellerInvoice invoice = new SellerInvoice();
        invoice.setInvoiceId(invoiceId);
        invoice.setInvoicePdf(pdf);

        sellerInvoiceService.saveSellerInvoice(invoice);

        return ResponseEntity.ok("Saved in Seller");
    }

    @PostMapping("/invoice/save")
    public void saveSellerInvoice(@RequestBody SellerInvoice invoice){
        sellerInvoiceService.saveSellerInvoice(invoice);
    }

}
