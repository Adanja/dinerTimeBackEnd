package com.example.demosetupproject.controller.dtos;

import com.example.demosetupproject.model.Review;

public class ReviewDto {
    public long id;

    public String description;
    public String title;
    public String username;
    public String date;
    public Double ratedStars;

    public static ReviewDto fromReview(Review review) {
        var dto = new ReviewDto();
        dto.id = review.getId();
        dto.description = review.getDescription();
        dto.title = review.getTitle();
        dto.username = review.getUsername();
        dto.date = review.getDate();
        dto.ratedStars = review.getRatedStars();

        return dto;
    }
}
