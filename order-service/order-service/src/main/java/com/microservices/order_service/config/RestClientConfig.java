package com.microservices.order_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * Author: Upashna
 * Created: 9/25/2026
 */
@Configuration
public class RestClientConfig {
    @Bean
    public RestClient restClient() {
        return RestClient.builder().build();
    }
}
