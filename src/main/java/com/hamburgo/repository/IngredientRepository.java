package com.hamburgo.repository;

import com.hamburgo.model.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ingredient", path = "ingredient")
public interface IngredientRepository extends MongoRepository<Ingredient, Long> {

}