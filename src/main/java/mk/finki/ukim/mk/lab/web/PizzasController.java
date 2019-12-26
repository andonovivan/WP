package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.Requests.PizzaRequest;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pizzas")
public class PizzasController {
    PizzaService pizzaService;

    public PizzasController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<Pizza> getPizzas(@RequestParam(name = "totalIngredients", required = false) Optional<Integer> totalIngredients) {
//        return this.pizzaService.listPizzas().stream().filter(pizza -> pizza.getIngredients().length < totalIngredients).collect(Collectors.toList());
        return this.pizzaService.listPizzas();
    }

    @PostMapping()
    public void createPizza(@RequestParam String name, @RequestParam String description, @RequestParam String ingredient) {
        pizzaService.createPizza(name, description, ingredient);
    }

    @PutMapping("/{id}")
    public void editPizza(@PathVariable Long id, @RequestParam String pizzaName, @RequestParam String description, @RequestParam String ingredient) {
        pizzaService.editPizza(id, pizzaName, description, ingredient);
    }

    @GetMapping("/{id}")
    public Pizza getPizzaById(@PathVariable Long id) {
        return pizzaService.findPizzaById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePizza(@PathVariable Long id) {
        pizzaService.deletePizza(id);
    }

}
