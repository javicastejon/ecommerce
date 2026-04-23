package com.ejemplonosql.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.ejemplonosql.ecommerce.infrastructure.ai.GeminiAIService;


@SpringBootTest(properties = "spring.profiles.active=dev")
class EcommerceApplicationTests {

    @MockitoBean
    private GeminiAIService geminiAIService;

	@Test
	void contextLoads() {
	}

}
