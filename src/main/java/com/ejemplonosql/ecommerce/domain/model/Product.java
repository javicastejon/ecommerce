package com.ejemplonosql.ecommerce.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

<<<<<<< HEAD
import lombok.Data;
=======
>>>>>>> feature-gemini-ai
import lombok.Getter;
import lombok.Setter;

@Document(collection = "products")
@Getter
@Setter
public class Product {
   private String id;
   private String name;
   private double price;
}

