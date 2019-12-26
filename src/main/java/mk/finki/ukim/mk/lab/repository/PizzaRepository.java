package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    Pizza findPizzaById(Long id);

    List<Pizza> findAll();

    List<Pizza> findAllByIngredientsContains(Ingredient ingredient);

    @Modifying
    @Query(value = "UPDATE pizzas set name = :name , description = :description , ingredients = :ingredients where id = :id", nativeQuery = true)
    void editPizza(Long id, String name, String description, List<Ingredient> ingredients);
}
