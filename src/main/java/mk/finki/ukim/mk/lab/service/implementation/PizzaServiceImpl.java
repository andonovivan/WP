package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.Requests.PizzaRequest;
import mk.finki.ukim.mk.lab.repository.IngredientsRepository;
import mk.finki.ukim.mk.lab.repository.PizzaMockRepository;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService {

    private PizzaRepository pizzaRepository;
    private IngredientsRepository ingredientsRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository, IngredientsRepository ingredientsRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientsRepository = ingredientsRepository;

    }

    @Override
    public Pizza findPizzaById(Long id) {
        return pizzaRepository.findPizzaById(id);
    }

    @Override
    public void createPizza(String name, String description, String ingredientName) {
        Ingredient ingredient = ingredientsRepository.findByName(ingredientName);
        Pizza pizza = new Pizza(name, description, ingredient, false);
        this.pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> listPizzas() {
        return pizzaRepository.findAll();
    }


    @Transactional
    @Override
    public void editPizza(Long id, String name, String description, String ingredientName) {
        Ingredient ingredient = ingredientsRepository.findByName(ingredientName);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        pizzaRepository.editPizza(id, name, description, ingredients);
    }

    @Override
    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }

    @Override
    public List<Pizza> getPizzasWithIngredient(Ingredient ingredient) {
        return pizzaRepository.findAllByIngredientsContains(ingredient);
    }


}
