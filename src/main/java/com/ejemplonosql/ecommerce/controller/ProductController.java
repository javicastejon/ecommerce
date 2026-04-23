package com.ejemplonosql.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplonosql.ecommerce.domain.model.Product;
import com.ejemplonosql.ecommerce.dto.ProductRequest;
import com.ejemplonosql.ecommerce.dto.ProductResponse;
import com.ejemplonosql.ecommerce.mapper.ProductMapper;
import com.ejemplonosql.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper mapper;

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        Product product = productService.createProduct(mapper.toEntity(productRequest));
        return mapper.toDTO(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.removeProduct(id);
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable String id) {
        Product user = productService.getProductById(id).orElse(null);
        return mapper.toDTO(user);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@RequestBody ProductRequest productRequest){
        Product productEntity = mapper.toEntity(productRequest);
        productService.update(productEntity);
        return mapper.toDTO(productEntity);
    }

    @GetMapping("/getall")
    public List<Product> getAllProducts() {
        return productService.getAll();
        
    }
}
