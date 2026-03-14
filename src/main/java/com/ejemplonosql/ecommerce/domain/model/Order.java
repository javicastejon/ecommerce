package com.ejemplonosql.ecommerce.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter 
@Setter
@Table(name="orders")
public class Order {
   @Id @GeneratedValue
   private Long id;
   private LocalDateTime createdAt;
   private double total;
   
   public Order() {
   }
   public Order(Long id, LocalDateTime createdAt, double total, User user, List<OrderLine> orderLines) {
      this.id = id;
      this.createdAt = createdAt;
      this.total = total;
      this.user = user;
      this.orderLines = orderLines;
   }
   @ManyToOne
   @JoinColumn(name="user_id")
   private User user;
   @OneToMany(mappedBy="order", cascade=CascadeType.ALL)
   private List<OrderLine> orderLines = new ArrayList<>();
}

