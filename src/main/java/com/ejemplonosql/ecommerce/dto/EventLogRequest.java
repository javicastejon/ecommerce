package com.ejemplonosql.ecommerce.dto;


import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EventLogRequest {
   private String message;
   private LocalDateTime date;
}