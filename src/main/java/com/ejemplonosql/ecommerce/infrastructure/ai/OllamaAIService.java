package com.ejemplonosql.ecommerce.infrastructure.ai;

import java.util.List;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import com.ejemplonosql.ecommerce.domain.model.Product;

@Service
public class OllamaAIService {

    private final OllamaChatModel chatModel;

    public OllamaAIService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getRecommendations(List<Product> productList) {

        String prompt = """
            Eres un recomendador de productos de e-commerce.
            Lista de productos:
            %s
            Devuelve 2 productos recomendados.
            Formato: lista simple.
            """.formatted(productList);

        return chatModel.call(prompt);
    }
}
