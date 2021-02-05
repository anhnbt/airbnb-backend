package com.codegym.airbnb.services;

import com.codegym.airbnb.model.Review;

import java.util.Optional;

public interface ReviewService {
    Iterable<Review> findAll();
    Optional<Review> findById(Long id);
    Review save(Review review);
}
