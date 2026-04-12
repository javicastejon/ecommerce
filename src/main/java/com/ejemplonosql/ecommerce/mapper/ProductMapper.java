package com.ejemplonosql.ecommerce.mapper;

import org.springframework.stereotype.Component;

import com.ejemplonosql.ecommerce.domain.model.Product;
import com.ejemplonosql.ecommerce.dto.ProductRequest;
import com.ejemplonosql.ecommerce.dto.ProductResponse;

@Component
public class ProductMapper {
    public ProductResponse toDTO(Product product){
        ProductResponse prodresponse = new ProductResponse();
        prodresponse.setId(product.getId());
        prodresponse.setName(product.getName());
        prodresponse.setPrice(product.getPrice());
        
        return prodresponse;
    }

    public Product toEntity(ProductRequest dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return product;
    }
}
