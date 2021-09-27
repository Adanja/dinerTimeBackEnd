package com.example.demosetupproject.service;

import com.example.demosetupproject.exceptions.RecordNotFoundException;
import com.example.demosetupproject.model.Review;
import com.example.demosetupproject.repository.PictureRepository;
import com.example.demosetupproject.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{
    private ReviewRepository reviewRepository;
//    private UserDataRepository userDataRepository;
    private PictureRepository pictureRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, PictureRepository pictureRepository) {

        this.reviewRepository = reviewRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review getReview(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            return review.get();
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review newReview) {
        if (!reviewRepository.existsById(id)) throw new RecordNotFoundException();
        Review review = reviewRepository.findById(id).get();
        review.setUsername(newReview.getUsername());
        review.setDescription(newReview.getDescription());
        review.setTitle(newReview.getTitle());
        review.setDate(newReview.getDate());
        review.setRatedStars(newReview.getRatedStars());
        reviewRepository.save(review);

        return review;
    }

    @Override
    public Review calculateRatedStars(Review review) {
        return null;
    }

    @Override
    public void assignPictureToReview(Long id, Long pictureId) {

        var optionalReview = reviewRepository.findById(id);

        var optionalPicture = pictureRepository.findById(pictureId);

        if (optionalReview.isPresent() && optionalPicture.isPresent()) {

            var review = optionalReview.get();

            var picture = optionalPicture.get();

            review.setPicture(picture);

            reviewRepository.save(review);

        } else {

            throw new RecordNotFoundException();

        }

    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

}
