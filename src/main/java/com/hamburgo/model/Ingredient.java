package com.hamburgo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ingredient {

    @Id
    private Long id;
    private String name;
    private Double price;
    private Integer number;

    public Long getId() {
        return id;
    }

    public Ingredient setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Ingredient setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Ingredient setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public Ingredient setNumber(Integer number) {
        this.number = number;
        return this;
    }
}
