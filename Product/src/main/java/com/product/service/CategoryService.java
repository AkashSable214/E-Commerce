package com.product.service;

import com.product.model.Category;
import com.product.model.Product;

import java.util.List;

public interface CategoryService {


        List<Category> getAllCategories();

        List<Product> getProductsByCategory(Long categoryId);

        Category createCategory(Category category);

        Category updateCategory(Long id, Category category);

        void deleteCategory(Long id);

        Category getCategoryById(Long id);
    }



