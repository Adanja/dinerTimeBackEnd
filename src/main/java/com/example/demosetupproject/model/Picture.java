package com.example.demosetupproject.model;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

@Entity
public class Picture {

    @Id
    @GeneratedValue
    Long id;

    public String name;
    public String type;

    @Lob
    byte[] data;

    @OneToOne(mappedBy = "picture")
    Review review;

    @OneToOne(mappedBy = "picture")
    Recipe recipe;

    public Picture() {
    };

    public Picture(String name, String type, byte[] data) {

        this.name = name;

        this.type = type;

        this.data = data;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public byte[] getData() {
        return data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
