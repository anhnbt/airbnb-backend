package com.codegym.airbnb.repositories;

import com.codegym.airbnb.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
