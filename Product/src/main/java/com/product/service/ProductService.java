package com.product.service;

import com.product.model.Product;
import org.springframework.web.multipart.MultipartFile;

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

    Product saveProductWithImage(Product product, MultipartFile file) throws Exception;
}
