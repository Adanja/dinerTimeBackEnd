package com.example.demosetupproject.controller;

import com.example.demosetupproject.controller.dtos.IdInputDto;
import com.example.demosetupproject.controller.dtos.RecepyInputDto;
import com.example.demosetupproject.controller.dtos.RecipeDto;
import com.example.demosetupproject.model.Recipe;
import com.example.demosetupproject.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("recipies")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<RecipeDto> getAllRecipes() {
        var dtos = new ArrayList<RecipeDto>();
        var recipes = recipeService.getAllRecipes();
        for (Recipe recipe :recipes) {
            dtos.add(RecipeDto.fromRecipe(recipe));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public RecipeDto getRecipe(@PathVariable("id") Long id) {
        var recipe = recipeService.getRecipe(id);
        return RecipeDto.fromRecipe(recipe);
    }

    @PostMapping
    public RecipeDto saveRecipe(@RequestBody RecepyInputDto dto) {
        var recipe = recipeService.saveRecipe(dto.toRecipe());
        return RecipeDto.fromRecipe(recipe);
    }

    @PutMapping("/{id}")
    public RecipeDto updateRecipe(@PathVariable("id") Long id, @RequestBody Recipe recipe) {
        recipeService.updateRecipe(id, recipe);
        return RecipeDto.fromRecipe(recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable ("id")Long id) {
        recipeService.deleteRecipe(id);
    }

    @PutMapping("/recipe/{id}/pictures")
    public void assignPictureToRecipe (@PathVariable ("id")Long recipeId, @RequestBody IdInputDto idInputDto) {
        recipeService.assignPictureToRecipe(recipeId, idInputDto.id);
    }

//    Hoe en waar koppel ik reviewId aan deze put mapping?
    @PutMapping("/recipe/{id}/reviews")
    public void assignReviewToRecipe(@PathVariable ("id")Long recipeId, Long reviewId, @RequestBody IdInputDto inputDto) {
       recipeService.assignReviewtoRecipe(recipeId, inputDto.id);
    }

}
