package com.hamburgo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Order {

    @Id
    private Long id;
    private List<Hamburguer> hamburguers;
    private List<CustomHamburguer> customHamburguers;

    public List<Hamburguer> getHamburguers() {
        return hamburguers;
    }

    public Order setHamburguers(List<Hamburguer> hamburguers) {
        this.hamburguers = hamburguers;
        return this;
    }

    public List<CustomHamburguer> getCustomHamburguers() {
        return customHamburguers;
    }

    public Order setCustomHamburguers(List<CustomHamburguer> customHamburguers) {
        this.customHamburguers = customHamburguers;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

}
