package com.example.demosetupproject.repository;

import com.example.demosetupproject.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findByNameEquals(String name);
}
