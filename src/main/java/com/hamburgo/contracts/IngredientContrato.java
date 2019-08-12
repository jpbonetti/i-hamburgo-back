package com.hamburgo.contracts;

import com.hamburgo.model.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public interface IngredientContrato {

    @GetMapping("/findAll")
    ResponseEntity<List<Ingredient>> findAll();

    @PostMapping("/save")
    void save(@RequestBody Ingredient ingredient);

    @DeleteMapping("/delete/{idIngredient}")
    void delete(@PathVariable("idIngredient") Long idIngredient);
}
