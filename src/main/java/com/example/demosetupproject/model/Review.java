package com.example.demosetupproject.model;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String description;
    String title;
    String username;
    String date;
    Double ratedStars;


    @OneToOne
    Picture picture;

    public Double getRatedStars() {
        return ratedStars;
    }

    public void setRatedStars(Double ratedStars) {
        this.ratedStars = ratedStars;
    }

    public Review() {
    }

    public Review(String description, String title, String username, String date) {
        this.description = description;
        this.title = title;
        this.username = username;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

//    Generate date
    public void setDate(String date) {
        this.date = date;
    }


}
