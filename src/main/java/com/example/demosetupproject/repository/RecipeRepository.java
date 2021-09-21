package com.example.demosetupproject.repository;

import com.example.demosetupproject.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository <Recipe, Long> {

}
