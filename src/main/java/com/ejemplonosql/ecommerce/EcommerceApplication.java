package com.ejemplonosql.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClients;



@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

    @Bean
    public MongoTemplate mongoTemplate() {
        String uri = "mongodb://localhost:27017/shoplogs";
        return new MongoTemplate(MongoClients.create(uri), "shoplogs");
    }
}
