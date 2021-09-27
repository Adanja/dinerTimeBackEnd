package com.example.demosetupproject.service;

import com.example.demosetupproject.model.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe saveRecipe(Recipe recipe);
    Recipe getRecipe(Long id);
    List<Recipe> getAllRecipes();
    void updateRecipe(Long id, Recipe recipe);
    void deleteRecipe(Long id);
    void assignPictureToRecipe(Long id, Long pictureId);
    void assignReviewtoRecipe (Long id, Long reviewId);
}
