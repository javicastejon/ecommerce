package com.ejemplonosql.ecommerce.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplonosql.ecommerce.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
