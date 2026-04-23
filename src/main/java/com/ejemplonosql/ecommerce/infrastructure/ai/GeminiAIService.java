package com.ejemplonosql.ecommerce.infrastructure.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;

@Service
public class GeminiAIService {
    private final Client chatClient;
    private final String modelName = "gemini-2.5-flash-lite"; 

    // apiKey: Os dejo mi apikey para hacer alguna prueba
    // La quitare y teneis que pasarla como env var
    public GeminiAIService() {
        this.chatClient = Client.builder()
            .apiKey("AIzaSyA-J3zLWawWQdv0i01JL2gKVIG_-bAGbFo") 
            .build();
    }

    public String chat(String message) {
        try {
            GenerateContentResponse response = this.chatClient.models.generateContent(
                modelName,
                message,
                null 
            );
            return response.text();         
        } catch (Exception e) {
            e.printStackTrace(); 
            return "Error al conectar con Gemini: " + e.getMessage();
        }
    }
}
