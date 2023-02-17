package pro.sky.lesson28skypro.services;

import pro.sky.lesson28skypro.model.Recipes;

import java.util.Collection;

public interface RecipesService {

    int addRecipe(Recipes recipe);

    Recipes getRecipe(int id);

    Collection<Recipes> getAllRecipe();

    Recipes editRecipe(int id, Recipes recipes);

    Recipes removeRecipe(int id);
}
