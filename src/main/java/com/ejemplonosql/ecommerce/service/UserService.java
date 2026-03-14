package com.ejemplonosql.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ejemplonosql.ecommerce.domain.model.User;
import com.ejemplonosql.ecommerce.domain.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(User user){
        User userdb = userRepository.save(user);
        
        return userdb;
    }

    public void removeUser(Long id){
        userRepository.deleteById(id);
        
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    // Importante: se tiene que usar un modelo distinto ya que el objeto enviado está detached
    @Transactional
    public void update(User user) {
        userRepository
                .findById(user.getId()) 
                .ifPresent(userdb -> {
                    userdb.setName(user.getName());
                    userdb.setEmail(user.getEmail());
                    userdb.setOrders(user.getOrders());
                    userRepository.save(userdb);
                });
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }   

    // @Cacheable("users")
    public List<User> getAll(){
        return userRepository.findAll();
    }
}
