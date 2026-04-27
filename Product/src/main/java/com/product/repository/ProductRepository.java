package com.product.repository;

import com.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


        List<Product> findByCategoryCategoryId(Long categoryId);

        List<Product> findByProductname(String productname);

        List<Product> findByPrice(double price);

        List<Product> findByBrand(String brand);
    }

