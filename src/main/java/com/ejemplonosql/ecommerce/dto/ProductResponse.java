package com.ejemplonosql.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductResponse {
   private String id;
   private String name;
   private Double price;
}