package com.product.service;

import com.product.model.*;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    List<Product> getProductsByCategory(Long categoryId);

    Product getProductById(Long productId);

    Product createProduct (Product product,MultipartFile imageFile);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    List<Product> getByProductName(String name);

    List<Product> getByPrice(double price);

    List<Product> getByBrand(String brand);
}

