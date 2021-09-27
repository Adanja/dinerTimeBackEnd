package com.example.demosetupproject.service;


import com.example.demosetupproject.exceptions.RecordNotFoundException;
import com.example.demosetupproject.model.Recipe;
import com.example.demosetupproject.repository.PictureRepository;
import com.example.demosetupproject.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RecipeServiceImpl implements RecipeService {
    private RecipeRepository recipeRepository;
    private PictureRepository pictureRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, PictureRepository pictureRepository) {
        this.recipeRepository = recipeRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe getRecipe(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(recipe.isPresent()) {
            return recipe.get();
        } else{
            throw new RecordNotFoundException();
        }
    }


    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public void updateRecipe(Long id, Recipe newRecipe) {
        if (!recipeRepository.existsById(id))throw new RecordNotFoundException();
        Recipe recipe = recipeRepository.findById(id).get();
        recipe.setDescription(newRecipe.getDescription());
        recipe.setTime(newRecipe.getTime());
        recipe.setDifficultyRating(newRecipe.getDifficultyRating());
        recipe.setName(newRecipe.getName());
        recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public void assignPictureToRecipe(Long id, Long pictureId) {
        var optionalRecipe = recipeRepository.findById(id);

        var optionalPicture = pictureRepository.findById(pictureId);

        if (optionalRecipe.isPresent() && optionalPicture.isPresent()) {
            var recipe = optionalRecipe.get();
            var picture = optionalPicture.get();

            recipe.setPicture(picture);
            recipeRepository.save(recipe);
        } else {
            throw new RecordNotFoundException();
        }
    }

}
