package com.recipeproject.recipe.repositories;

import com.recipeproject.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
