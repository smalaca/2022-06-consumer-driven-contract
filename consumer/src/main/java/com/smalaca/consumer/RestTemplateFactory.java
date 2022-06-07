package com.smalaca.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateFactory {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
