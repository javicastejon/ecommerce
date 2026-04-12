package com.ejemplonosql.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplonosql.ecommerce.domain.model.Product;
import com.ejemplonosql.ecommerce.domain.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product createProduct(Product user){
        Product userdb = productRepository.save(user);
        
        return userdb;
    }

    public void removeProduct(String id){
        productRepository.deleteById(id);
        
    }

    public Optional<Product> getProductById(String id){
        return productRepository.findById(id);
    }

    // Importante: se tiene que usar un modelo distinto ya que el objeto enviado está detached
    @Transactional
    public void update(Product product) {
        productRepository
                .findById(product.getId()) 
                .ifPresent(productdb -> {
                    productdb.setName(product.getName());
                    productdb.setPrice(product.getPrice());
                    productRepository.save(productdb);
                });
    }

    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }   

    public List<Product> getAll(){
        return productRepository.findAll();
    }
}
