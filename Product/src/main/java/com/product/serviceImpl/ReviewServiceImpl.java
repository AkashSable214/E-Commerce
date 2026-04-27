package com.product.serviceImpl;

import com.product.model.Review;
import com.product.repository.ReviewRepository;
import com.product.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProductProductId(productId);
    }
}

