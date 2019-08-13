package com.hamburgo.repository;

import com.hamburgo.model.Promotion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "promotion", path = "promotion")
public interface PromotionRepository extends MongoRepository<Promotion, Long> {

}