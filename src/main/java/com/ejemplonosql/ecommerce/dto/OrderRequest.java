package com.ejemplonosql.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ejemplonosql.ecommerce.domain.model.OrderLine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
   private String id;
   private LocalDateTime createdAt;
   private double total;
   private String userid;
   private List<OrderLine> orderLines = new ArrayList<>();
    
}
