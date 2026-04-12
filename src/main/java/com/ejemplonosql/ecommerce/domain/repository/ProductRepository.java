package com.ejemplonosql.ecommerce.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ejemplonosql.ecommerce.domain.model.Product;

public interface ProductRepository extends MongoRepository<Product,String>{
    
}
