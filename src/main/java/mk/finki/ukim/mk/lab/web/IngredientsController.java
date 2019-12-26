package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.Requests.IngredientRequest;
import mk.finki.ukim.mk.lab.service.IngredientsService;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    private final IngredientsService ingredientsService;
    private final PizzaService pizzaService;

    public IngredientsController(IngredientsService ingredientsService, PizzaService pizzaService) {
        this.ingredientsService = ingredientsService;
        this.pizzaService = pizzaService;
    }

    @GetMapping()
    public List<Ingredient> getAllIngredients() {
        return this.ingredientsService.getAll();
    }

    @PostMapping()
    public void createIngredients(@RequestParam String name, @RequestParam Boolean spicy, @RequestParam Float amount) {
        ingredientsService.saveIngredient(name, spicy, amount);
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable Long id) {
        return ingredientsService.findById(id);
    }

    @PatchMapping("/{id}")
    public void editIngredient(@PathVariable Long id, @RequestParam String name, @RequestParam Boolean spicy, @RequestParam Float amount) {
        ingredientsService.editIngredient(id, name, spicy, amount);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientsService.deleteIngredient(id);
    }

    @GetMapping("/spicy")
    public List<Ingredient> getSpicyIngredients() {
        return ingredientsService.findSpicy();
    }

    @GetMapping("/{id}/pizzas")
    public List<Pizza> getPizzasWithIngredient(@PathVariable Long id) {
        Ingredient ingredient = ingredientsService.findById(id);
        return pizzaService.getPizzasWithIngredient(ingredient);
    }
}
