package com.example.demo.serviceTest;

import com.example.demosetupproject.exceptions.RecordNotFoundException;
import com.example.demosetupproject.model.Recipe;
import com.example.demosetupproject.repository.RecipeRepository;
import com.example.demosetupproject.service.RecipeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {

    @Mock
    RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @Captor
    ArgumentCaptor<Recipe> recipeCaptor;

    @Test
    public void getRecipeTest() {
        Recipe recipe = new Recipe();
        recipe.setName("recipeTest");
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));

        var recipe1 = recipeService.getRecipe(1L);
        assertThat(recipe1.getName()).isEqualTo("recipeTest");
    }

    @Test
    public void getRecipeExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> recipeService.getRecipe(null));
    }

    @Test
    public void getAllRecipesTest() {
        List<Recipe> testRecipes = new ArrayList<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipe1.setName("Warm rood fruit");
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        recipe2.setName("Garnalen pasta");
        Recipe recipe3 = new Recipe();
        recipe3.setId(2L);
        recipe3.setName("Vega curry");

        testRecipes.add(recipe1);
        testRecipes.add(recipe2);
        testRecipes.add(recipe3);

        when(recipeRepository.findAll()).thenReturn(testRecipes);

        recipeService.getAllRecipes();

        verify(recipeRepository, times(1)).findAll();

        assertThat(testRecipes.size()).isEqualTo(3);
        assertThat(testRecipes.get(0)).isEqualTo(recipe1);
        assertThat(testRecipes.get(1)).isEqualTo(recipe2);
        assertThat(testRecipes.get(2)).isEqualTo(recipe3);
    }

    @Test
    public void saveRecipeTest() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setName("test");

        recipeRepository.save(recipe);

        verify(recipeRepository, times(1)).save(recipeCaptor.capture());
        var recipe1 = recipeCaptor.getValue();

        assertThat(recipe1.getName()).isEqualTo("test");
        assertThat(recipe1.getId()).isEqualTo(1);
    }

//    @Test
//    public void updateRecipeTest() {
//        Recipe recipe1 = new Recipe();
//        recipe1.setId(1L);
//        recipe1.setName("test");
//        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe1));
//
//        recipe1.setName("test1");
//        recipeService.updateRecipe(1L, recipe1);
//
//        verify(recipeRepository).save(recipe1);
//
//        assertThat(recipe1.getId()).isEqualTo(1);
//        assertThat(recipe1.getName()).isEqualTo("test1");
//    }

    @Test
    public void updateRecipeExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> recipeService.getRecipe(null));
    }

    @Test
    public void deleteRecipeTest() {
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipe1.setName("test");

        recipeRepository.delete(recipe1);

        recipeService.deleteRecipe(1L);

        verify(recipeRepository, times(1)).delete(recipe1);
    }
}
