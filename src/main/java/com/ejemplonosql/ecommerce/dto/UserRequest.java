package com.ejemplonosql.ecommerce.dto;

import java.util.List;




import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequest {
   private String id;
   private String name;
   private String email;
   private List<Long> orders;
}
