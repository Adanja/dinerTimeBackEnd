package com.example.demosetupproject.repository;

import com.example.demosetupproject.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
