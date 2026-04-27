package com.product.serviceImpl;

import com.product.model.*;
import com.product.repository.*;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryCategoryId(categoryId);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setProductname(product.getProductname());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setDiscountPrice(product.getDiscountPrice());
        existing.setBrand(product.getBrand());
        existing.setSku(product.getSku());
        existing.setWeight(product.getWeight());
        existing.setDimensions(product.getDimensions());
        existing.setColor(product.getColor());
        existing.setSize(product.getSize());
        existing.setRating(product.getRating());
        existing.setReviewCount(product.getReviewCount());

        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepository.delete(product);
    }

    @Override
    public List<Product> getByProductName(String name) {
        return productRepository.findByProductname(name);
    }

    @Override
    public List<Product> getByPrice(double price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public List<Product> getByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }
}

