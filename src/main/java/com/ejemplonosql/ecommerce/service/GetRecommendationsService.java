package com.ejemplonosql.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplonosql.ecommerce.domain.model.Product;
import com.ejemplonosql.ecommerce.infrastructure.ai.OllamaAIService;


@Service
public class GetRecommendationsService {

    private final OllamaAIService aiService;

    @Autowired
    private ProductService productService;

    public GetRecommendationsService(OllamaAIService aiService) {
        this.aiService = aiService;
    }

    public String execute(String userHistory) {
        List<Product> productList = productService.getAll();
        return aiService.getRecommendations(productList);
    }
}
