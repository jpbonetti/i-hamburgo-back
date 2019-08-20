package com.hamburgo.repository;

import com.hamburgo.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "order", path = "order")
public interface OrderRepository extends MongoRepository<Order, Long> {
    Optional<Order> findFirstByOrderByIdAsc();
}