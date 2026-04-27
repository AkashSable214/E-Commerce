package com.product.service;

import com.product.model.Review;

import java.util.List;

public interface ReviewService {

    Review createReview(Review review);

    List<Review> getReviewsByProductId(Long productId);
}


