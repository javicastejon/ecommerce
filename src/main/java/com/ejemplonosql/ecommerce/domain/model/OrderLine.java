package com.ejemplonosql.ecommerce.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderLine {
   private String order;
   private Product product;
   private int quantity;
}

