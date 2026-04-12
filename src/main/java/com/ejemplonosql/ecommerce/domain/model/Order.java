package com.ejemplonosql.ecommerce.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Document(collection = "orders")
@Getter
@Setter
public class Order {
   @Id
   private String id;
   private LocalDateTime createdAt;
   private double total;
   private String userid;
   private List<OrderLine> orderLines = new ArrayList<>();
}

