package com.hamburgo.environment;

import com.hamburgo.model.Ingredient;

import java.util.Arrays;
import java.util.List;

public class IngredientEnvironment {
    public static List<Ingredient> createListIngredients() {
        return Arrays.asList(
                createIngredient()
        );
    }

    public static Ingredient createIngredient() {
        return new Ingredient()
                .setId(1L)
                .setName("INGREDIENT NAME")
                .setNumber(1)
                .setPrice(10.00);
    }
}
