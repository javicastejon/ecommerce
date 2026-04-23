package com.ejemplonosql.ecommerce.service;

import org.springframework.stereotype.Service;

import com.ejemplonosql.ecommerce.infrastructure.ai.OllamaAIService;
import com.ejemplonosql.ecommerce.infrastructure.ai.GeminiAIService;

@Service
public class GetRecommendationsService {

    private final OllamaAIService aiService;
    
    private final GeminiAIService geminiAIService;

    public GetRecommendationsService(OllamaAIService aiService, GeminiAIService geminiAIService) {
        this.aiService = aiService;
        this.geminiAIService = geminiAIService;
    }

    public String queryOllama(String userHistory) {
        return aiService.chat(userHistory);
    }

    public String queryGemini(String userHistory){
        return geminiAIService.chat(userHistory);
    }
}
