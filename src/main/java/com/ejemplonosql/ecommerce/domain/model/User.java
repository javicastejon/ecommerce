package com.ejemplonosql.ecommerce.domain.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document(collection = "users")
@Getter
@Setter
public class User {
   private String id;
   private String name;
   private String email;

   private List<Long> orders = new ArrayList<>();
}

