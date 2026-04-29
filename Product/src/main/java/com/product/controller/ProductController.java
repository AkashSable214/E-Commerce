package com.product.controller;

import com.product.model.*;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.model.Product;
import com.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/productApi/v1")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


//    @PostMapping(value = "/product", consumes = "multipart/form-data")
//    public ResponseEntity<?> createProduct(
//            @RequestPart("product") Product product,
//            @RequestPart(value = "imageFile", required = false) MultipartFile imageFile) {
//
//        try {
//            Product saved = productService.createProduct(product, imageFile);
//            return new ResponseEntity<>(saved, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @PostMapping(value = "/product", consumes = {"multipart/form-data"})
//    public ResponseEntity<?> createProduct(
//            @RequestPart("product") Product product,
//            @RequestPart(value = "imageFile", required = false) MultipartFile imageFile) {
//
//        Product saved = productService.createProduct(product, imageFile);
//        return new ResponseEntity<>(saved, HttpStatus.CREATED);
//    }



    @PostMapping(value = "/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createProduct(
            @RequestPart("product") String productStr,
            @RequestPart(value = "imageFile", required = false) MultipartFile imageFile) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(productStr, Product.class);

            Product saved = productService.createProduct(product, imageFile);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }


//    @GetMapping("/product/image/{id}")
//    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
//        Product product = productService.getProductById(id);
//
//        return ResponseEntity.ok()
//                .header("Content-Type", product.getImageType())
//                .body(product.getImage());
//    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @GetMapping("/all-product")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        return ResponseEntity.ok(products);
    }
}