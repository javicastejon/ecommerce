package com.ejemplonosql.ecommerce.dto;

import java.util.List;

import com.ejemplonosql.ecommerce.domain.model.Order;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponse {
   private Long id;
   private String name;
   private String email;
   private List<Order> orders;
}

