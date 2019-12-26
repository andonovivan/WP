package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.repository.IngredientsRepository;
import mk.finki.ukim.mk.lab.service.IngredientsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private IngredientsRepository ingredientsRepository;

    public IngredientsServiceImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public void saveIngredient(String name, Boolean spicy, Float amount) {
        ingredientsRepository.save(new Ingredient(name, spicy, amount));
    }

    @Override
    public Ingredient findById(Long id) {
        return ingredientsRepository.findIngredientById(id);
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientsRepository.findAll();
    }

    @Transactional
    @Override
    public void editIngredient(Long id, String name, Boolean spicy, Float amount) {
        ingredientsRepository.editIngredient(id, name, spicy, amount);
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientsRepository.deleteById(id);
    }

    @Override
    public List<Ingredient> findSpicy() {
        return ingredientsRepository.findBySpicyIsTrue();
    }

}
