package com.hamburgo.repository;

import com.hamburgo.model.CustomHamburguer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customHamburguer", path = "customHamburguer")
public interface CustomHamburguerRepository extends MongoRepository<CustomHamburguer, Long> {

}