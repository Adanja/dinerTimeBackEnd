package com.example.demosetupproject.controller.dtos;

import com.example.demosetupproject.model.Recipe;

public class RecepyInputDto {
    public long id;

    public String name;
    public String time;
    public String difficultyRating;
    public String description;

    public Recipe toRecipe(){
        var recipe = new Recipe();
        recipe.setId(id);
        recipe.setName(name);
        recipe.setTime(time);
        recipe.setDifficultyRating(difficultyRating);
        recipe.setDescription(description);
        return recipe;
    }
}
