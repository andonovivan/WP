package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.Requests.PizzaRequest;

import java.util.List;

public interface PizzaService {

    Pizza findPizzaById(Long id);

    void createPizza(String name, String description,String ingredientName);

    List<Pizza> listPizzas();

    void editPizza(Long id, String pizzaName, String description, String ingredient);

    void deletePizza(Long id);

    List<Pizza> getPizzasWithIngredient(Ingredient ingredient);
}
