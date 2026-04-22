package com.ejemplonosql.ecommerce.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document(collection = "products")
@Getter
@Setter
public class Product {
   private String id;
   private String name;
   private double price;
}

