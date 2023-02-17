package pro.sky.lesson28skypro.services.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import pro.sky.lesson28skypro.model.Recipes;
import pro.sky.lesson28skypro.services.IngredientService;
import pro.sky.lesson28skypro.services.RecipesService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RecipesServiceImpl implements RecipesService {
    private Map<Integer, Recipes> recipesMap = new HashMap<>();
    private final IngredientService ingredientService;
    private static int id = 0;

    @Override
    public int addRecipe(Recipes recipe) {
        if (recipe.getIngredients() != null && !recipe.getIngredients().isEmpty()) {
            recipe.getIngredients().forEach(ingredientService::addIngredient);
        }
        recipesMap.put(id++, recipe);
        return id;
    }

    @Override
    public Recipes getRecipe(int id) {
        if (!recipesMap.containsKey(id)) {
            throw new NotFoundException("Рецепт с заданным id не найден");
        }
        return recipesMap.get(id);
    }

    @Override
    public Collection<Recipes> getAllRecipe() {
        return recipesMap.values();
    }

    @Override
    public Recipes editRecipe(int id, Recipes recipes) {
        if (!recipesMap.containsKey(id)) {
            throw new NotFoundException("Рецепт с заданным id не найден");
        }
        return recipesMap.put(id, recipes);
    }

    @Override
    public Recipes removeRecipe(int id) {
        if (!recipesMap.containsKey(id)) {
            throw new NotFoundException("Рецепт с заданным id отсутствует");
        }
        return recipesMap.remove(id);
    }
}
