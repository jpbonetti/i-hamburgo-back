package com.hamburgo.service;

import com.hamburgo.model.Ingredient;
import com.hamburgo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public void delete(Long idIngredient) {
        ingredientRepository.deleteById(idIngredient);
    }
}
