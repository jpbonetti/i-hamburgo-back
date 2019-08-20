package com.hamburgo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class CustomHamburguer {

    @Id
    private Long id;
    private String name;
    private String descryption;
    private Double price;
    private Integer number;
    private List<Ingredient> ingredients;

    public Long getId() {
        return id;
    }

    public CustomHamburguer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomHamburguer setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescryption() {
        return descryption;
    }

    public CustomHamburguer setDescryption(String descryption) {
        this.descryption = descryption;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public CustomHamburguer setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public CustomHamburguer setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public CustomHamburguer setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}