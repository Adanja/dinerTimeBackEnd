package com.example.demosetupproject.controller.dtos;

import com.example.demosetupproject.model.Recipe;

public class RecipeDto {
    public long id;

    String name;
    String time;
    String difficultyRating;
    String description;

    public static RecipeDto fromRecipe(Recipe recipe) {
        var dto = new RecipeDto();
        dto.id = recipe.getId();
        dto.name = recipe.getName();
        dto.time = recipe.getTime();
        dto.difficultyRating = recipe.getDifficultyRating();
        dto.description = recipe.getDescription();
        return dto;
    }
}
