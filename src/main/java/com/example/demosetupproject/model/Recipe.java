package com.example.demosetupproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    Long id;

    String name;
    String time;
    String difficultyRating;
    String description;

    @OneToOne
    Picture picture;

    @OneToMany (mappedBy = "recipe")
    List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getDifficultyRating() {
        return difficultyRating;
    }

    public String getDescription() {
        return description;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDifficultyRating(String difficultyRating) {
        this.difficultyRating = difficultyRating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
