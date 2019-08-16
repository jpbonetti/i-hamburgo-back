package com.hamburgo.resources;

import com.hamburgo.contracts.IngredientContrato;
import com.hamburgo.model.Ingredient;
import com.hamburgo.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class IngredientResource implements IngredientContrato {

    @Autowired
    private IngredientService ingredientService;

    @Override
    public ResponseEntity<List<Ingredient>> findAll() {
        return ResponseEntity.ok(ingredientService.findAll());
    }

    @Override
    public void save(@RequestBody Ingredient ingredient) {
        ingredientService.save(ingredient);
    }

    @Override
    public void delete(@PathVariable("idIngredient") Long idIngredient) {
        ingredientService.delete(idIngredient);
    }
}