package com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProductManagementProducerFactory {
    private static final String URL = "http://localhost:8200/products";

    @Bean
    public ProductManagementProducer productManagementProducer() {
        return new ProductManagementProducer(new RestTemplate(), URL);
    }
}
