package com.ejemplonosql.ecommerce.domain.model;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Product {
   @Id @GeneratedValue
   private Long id;
   private String name;
   private double price;
   @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
   private List<OrderLine> orderLines = new ArrayList<>();
}

