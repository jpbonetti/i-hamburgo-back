package com.hamburgo.environment;

import com.hamburgo.model.CustomHamburguer;

import java.util.Arrays;
import java.util.List;

public class CustomHamburguerEnvironment {
    public static List<CustomHamburguer> createListCustomHamburguers() {
        return Arrays.asList(
                createCustomHamburguer()
        );
    }

    public static CustomHamburguer createCustomHamburguer() {
        return new CustomHamburguer()
                .setId(1L)
                .setName("CUSTOM HAMBURGUER NAME")
                .setDescryption("DESCRYPTION HAMBURGUER")
                .setIngredients(IngredientEnvironment.createListIngredients())
                .setNumber(1)
                .setPrice(15.00);
    }
}
