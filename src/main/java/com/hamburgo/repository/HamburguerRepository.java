package com.hamburgo.repository;

import com.hamburgo.model.Hamburguer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "hamburguer", path = "hamburguer")
public interface HamburguerRepository extends MongoRepository<Hamburguer, Long> {

}