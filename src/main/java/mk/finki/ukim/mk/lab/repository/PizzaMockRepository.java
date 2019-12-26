package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Pizza;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class PizzaMockRepository {
    private List<Pizza> pizzaList;

    public PizzaMockRepository() {

    }

    public List<Pizza> getAllPizzas() {
        return pizzaList;
    }
}
