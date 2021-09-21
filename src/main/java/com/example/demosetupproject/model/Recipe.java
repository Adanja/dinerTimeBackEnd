package com.example.demosetupproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    Long id;

    String name;
    String time;
    String difficultyRating;
    String description;

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
}
