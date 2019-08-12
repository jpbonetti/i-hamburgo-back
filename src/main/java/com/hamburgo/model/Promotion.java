package com.hamburgo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Promotion {

    @Id
    private Long id;
    private String name;
    private String descryption;

    public Long getId() {
        return id;
    }

    public Promotion setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Promotion setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescryption() {
        return descryption;
    }

    public Promotion setDescryption(String descryption) {
        this.descryption = descryption;
        return this;
    }
}
