package com.ejemplonosql.ecommerce.infrastructure.ai;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class OllamaAIService {

    private final OllamaChatModel chatModel;

    public OllamaAIService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String chat(String userHistory) {

        // String prompt = """
        //     Eres un recomendador de productos de e-commerce.
        //     Historial del usuario:
        //     %s
        //     Devuelve 3 productos recomendados.
        //     Formato: lista simple.
        //     """.formatted(userHistory);

        return chatModel.call(userHistory);
    }
}
