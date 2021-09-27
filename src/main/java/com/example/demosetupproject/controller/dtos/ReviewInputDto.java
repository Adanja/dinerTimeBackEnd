package com.example.demosetupproject.controller.dtos;

import com.example.demosetupproject.model.Review;

public class ReviewInputDto {
    public long id;

    public String description;
    public String title;
    public String username;
    public String date;
    public Double ratedStars;

    public Review toReview(){
        var review = new Review();
        review.setId(id);
        review.setDescription(description);
        review.setTitle(title);
        review.setUsername(username);
        review.setDate(date);
        review.setRatedStars(ratedStars);
        return review;
    }

}
