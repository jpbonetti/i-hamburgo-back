package com.hamburgo.environment;

import com.hamburgo.model.Promotion;

import java.util.Arrays;
import java.util.List;

public class PromotionEnvironment {
    public static List<Promotion> createListPromotions() {
        return Arrays.asList(
                createPromotion()
        );
    }

    public static Promotion createPromotion() {
        return new Promotion()
                .setId(1L)
                .setName("PROMOTION NAME")
                .setDescryption("PROMOTION DESCRYPTION");
    }
}
