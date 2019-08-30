package com.hamburgo.environment;

import com.hamburgo.model.Hamburguer;

import java.util.Arrays;
import java.util.List;

public class HamburguerEnvironment {
    public static List<Hamburguer> createListHamburguers() {
        return Arrays.asList(
                createHamburguer()
        );
    }

    public static Hamburguer createHamburguer() {
        return new Hamburguer()
                .setId(1L)
                .setName("HAMBURGUER NAME")
                .setDescryption("HAMBURGUER DESCRYPTION")
                .setNumber(1)
                .setPrice(10.00);
    }
}
