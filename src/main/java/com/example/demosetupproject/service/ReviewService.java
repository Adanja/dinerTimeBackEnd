package com.example.demosetupproject.service;

import com.example.demosetupproject.model.Review;

public interface ReviewService {
    Review saveReview(Review review);
    Review getReview(Long id);
    Review addReview(Review review);
    Review updateReview(Long id, Review review);
    Review calculateRatedStars(Review review);
//    void assignPicture(Long id, Long pictureId);
    void deleteReview(Long id);

    void assignPictureToReview(Long id, Long pictureId);
}
