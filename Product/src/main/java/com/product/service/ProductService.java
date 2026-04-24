package com.product.service;

import com.product.model.*;

import java.util.List;

public interface ProductService {

    List<Product> getProductsByCategory(Long categoryId);

    Product getProductById(Long productId);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    List<Product> getByProductName(String name);

    List<Product> getByPrice(double price);

    List<Product> getByBrand(String brand);
}

