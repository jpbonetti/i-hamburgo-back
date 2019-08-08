package com.hamburgo.model;

public class Hamburguer {

    private Long id;
    private String name;

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
}