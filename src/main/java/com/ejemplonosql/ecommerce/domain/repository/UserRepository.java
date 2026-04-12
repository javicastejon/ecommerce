package com.ejemplonosql.ecommerce.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ejemplonosql.ecommerce.domain.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
