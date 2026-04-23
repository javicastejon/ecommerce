package com.ejemplonosql.ecommerce.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ejemplonosql.ecommerce.domain.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,String>{
    
}
