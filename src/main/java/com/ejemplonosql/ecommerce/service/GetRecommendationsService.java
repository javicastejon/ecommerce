package com.ejemplonosql.ecommerce.service;

import org.springframework.stereotype.Service;

import com.ejemplonosql.ecommerce.infrastructure.ai.OllamaAIService;


@Service
public class GetRecommendationsService {

    private final OllamaAIService aiService;

    public GetRecommendationsService(OllamaAIService aiService) {
        this.aiService = aiService;
    }

    public String execute(String userHistory) {
        return aiService.getRecommendations(userHistory);
    }
}
