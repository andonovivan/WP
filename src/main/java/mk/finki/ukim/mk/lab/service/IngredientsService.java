package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Requests.IngredientRequest;

import java.util.List;

public interface IngredientsService {
    void saveIngredient(String name, Boolean spicey, Float amount);

    Ingredient findById(Long id);

    List<Ingredient> getAll();

    void editIngredient(Long id, String name,Boolean spicy,Float amount);

    void deleteIngredient(Long id);

    List<Ingredient> findSpicy();
}
