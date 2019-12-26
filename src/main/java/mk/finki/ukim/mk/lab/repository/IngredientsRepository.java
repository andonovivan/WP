package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findBySpicyIsTrue();

    Ingredient findByName(String name);

    Ingredient findIngredientById(Long id);

    List<Ingredient> findAll();

    @Modifying
    @Query(value = "UPDATE ingredients set name = :name, spicy = :spicy, amount = :amount where id = :id", nativeQuery = true)
    void editIngredient(Long id, String name, Boolean spicy, Float amount);
}
