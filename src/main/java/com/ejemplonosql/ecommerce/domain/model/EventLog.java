package com.ejemplonosql.ecommerce.domain.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document(collection = "events")
@Getter
@Setter
public class EventLog {

    @Id
    private String id;

    private String type;

    private String message;

    private LocalDateTime timestamp;

    private String userId;

    

    public EventLog() {
    }



    public EventLog(String id, String type, String message, LocalDateTime timestamp, String userId) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.timestamp = timestamp;
        this.userId = userId;
    }


    
}
