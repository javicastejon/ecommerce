package com.ejemplonosql.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductRequest {
   private String id;
   private String name;
   private Double price;
}
