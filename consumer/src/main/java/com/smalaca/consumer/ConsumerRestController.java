package com.smalaca.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer")
public class ConsumerRestController {
    private final RestTemplate restTemplate;

    public ConsumerRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("{param}")
    public String hello(@PathVariable String param) {
        String url = "http://localhost:8014/producer/" + param;
        return "Response is: " + restTemplate.getForObject(url, String.class);
    }
}
