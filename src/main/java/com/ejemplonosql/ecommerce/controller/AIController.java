package com.ejemplonosql.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ejemplonosql.ecommerce.dto.UserHistoryRequest;
import com.ejemplonosql.ecommerce.service.GetRecommendationsService;


import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/ai")
@CrossOrigin(origins = "*")
public class AIController {
    @Autowired
    private GetRecommendationsService useCase;

    @PostMapping("/queryOllama")
    public String getOllama(@RequestBody UserHistoryRequest query) {
        return useCase.queryOllama(query.getQuery());
    }

    @PostMapping("/queryGemini")
    public String getGemini(@RequestBody UserHistoryRequest query) {
        return useCase.queryGemini(query.getQuery());
    }
}
