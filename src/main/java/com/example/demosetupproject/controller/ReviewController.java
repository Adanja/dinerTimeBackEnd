package com.example.demosetupproject.controller;

import com.example.demosetupproject.controller.dtos.ReviewDto;
import com.example.demosetupproject.controller.dtos.ReviewInputDto;
import com.example.demosetupproject.model.Review;
import com.example.demosetupproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ReviewDto getReview(@PathVariable("id") Long id) {
        var review = reviewService.getReview(id);
        return ReviewDto.fromReview(review);
    }

    @PostMapping
    public ReviewDto saveReview (@RequestBody ReviewInputDto dto) {
        var review = reviewService.saveReview(dto.toReview());
        return ReviewDto.fromReview(review);
    }

    @PutMapping("{/id}")
    public ReviewDto updateReview(@PathVariable("id") Long id, @RequestBody Review review) {
        reviewService.updateReview(id, review);
        return ReviewDto.fromReview(review);
    }

    @DeleteMapping("/{id}")
        public void deleteReview(@PathVariable ("id")Long id) {
            reviewService.deleteReview(id);
    }

}
