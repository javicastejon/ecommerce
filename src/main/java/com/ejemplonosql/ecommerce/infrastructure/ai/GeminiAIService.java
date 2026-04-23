package com.ejemplonosql.ecommerce.infrastructure.ai;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

@Service
public class GeminiAIService {
    private final Client chatClient;
    private final String modelName = "gemini-2.5-flash-lite"; 

    public GeminiAIService(@Value("${gemini.api.key}") String apiKey) {
        this.chatClient = Client.builder()
            .apiKey(apiKey) 
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
