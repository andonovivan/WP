package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "pizzas")
@NoArgsConstructor
@Data
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Ingredient> ingredients;

    private Boolean veggie;

    public Pizza(String name, String description, Ingredient ingredient, Boolean veggie) {
        this.name = name;
        this.description = description;
        this.ingredients = new ArrayList<>();
        this.ingredients.add(ingredient);
        this.veggie = veggie;
    }
}

