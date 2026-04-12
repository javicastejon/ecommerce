package com.ejemplonosql.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/recom")
    public String get(@RequestBody UserHistoryRequest query) {
        return useCase.execute(query.getQuery());
    }
}
