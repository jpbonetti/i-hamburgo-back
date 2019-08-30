package com.hamburgo.environment;

import com.hamburgo.model.Order;

public class OrderEnvironment {
    public static Order createOrder() {
        return new Order()
                .setId(1L)
                .setHamburguers(HamburguerEnvironment.createListHamburguers());
    }
}
