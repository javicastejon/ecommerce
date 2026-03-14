package com.ejemplonosql.ecommerce.domain.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="users")
public class User {
   @Id @GeneratedValue
   private Long id;
   private String name;
   private String email;

   public User(){
      
   }

   public User(Long id, String name, String email, List<Order> orders) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.orders = orders;
   }

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
   private List<Order> orders = new ArrayList<>();
}

