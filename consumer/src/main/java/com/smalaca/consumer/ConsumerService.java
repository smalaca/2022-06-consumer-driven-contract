package com.smalaca.consumer;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class ConsumerService {
    private final RestTemplate restTemplate;

    ConsumerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String hello(String param) {
        String url = "http://localhost:8014/producer/" + param;
        return "Response is: " + restTemplate.getForObject(url, String.class);
    }
}
