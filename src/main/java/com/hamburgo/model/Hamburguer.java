package com.hamburgo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hamburguer {

    @Id
    private Long id;
    private String name;
    private String descryption;
    private Double price;
    private Integer number;

    public Long getId() {
        return id;
    }

    public Hamburguer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Hamburguer setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescryption() {
        return descryption;
    }

    public Hamburguer setDescryption(String descryption) {
        this.descryption = descryption;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Hamburguer setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public Hamburguer setNumber(Integer number) {
        this.number = number;
        return this;
    }
}