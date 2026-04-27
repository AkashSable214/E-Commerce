package com.product.controller;

import com.product.model.*;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/productApi/v1")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @PostMapping(value = "/product", consumes = "multipart/form-data")
    public ResponseEntity<Product> createProduct(@RequestPart("product") Product product,
                                                 @RequestPart("file") MultipartFile file) throws Exception
    {
        Product saved = productService.saveProductWithImage(product, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
                                                 @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/product/name/{name}")
    public ResponseEntity<List<Product>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.getByProductName(name));
    }

    @GetMapping("/product/price/{price}")
    public ResponseEntity<List<Product>> getByPrice(@PathVariable double price) {
        return ResponseEntity.ok(productService.getByPrice(price));
    }

    @GetMapping("/product/brand/{brand}")
    public ResponseEntity<List<Product>> getByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(productService.getByBrand(brand));
    }
}

