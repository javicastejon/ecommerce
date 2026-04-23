package com.ejemplonosql.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplonosql.ecommerce.domain.model.Product;
import com.ejemplonosql.ecommerce.infrastructure.ai.OllamaAIService;
import com.ejemplonosql.ecommerce.infrastructure.ai.GeminiAIService;

@Service
public class GetRecommendationsService {

    private final OllamaAIService aiService;
    
    private final GeminiAIService geminiAIService;

    @Autowired
    private ProductService productService;
    public GetRecommendationsService(OllamaAIService aiService, GeminiAIService geminiAIService) {
        this.aiService = aiService;
        this.geminiAIService = geminiAIService;
    }

    public String queryOllama(String userHistory) {
        List<Product> productList = productService.getAll();
        return aiService.chat(productList);
    }

    public String queryGemini(String userHistory){
        return geminiAIService.chat(userHistory);
    }
}
