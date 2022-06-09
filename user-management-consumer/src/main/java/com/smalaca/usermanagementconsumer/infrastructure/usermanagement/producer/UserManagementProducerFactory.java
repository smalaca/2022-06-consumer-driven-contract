package com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserManagementProducerFactory {
    private static final String URL = "http://localhost:8100/users";

    @Bean
    public UserManagementProducer userManagementProducer() {
        return new UserManagementProducer(new RestTemplate(), URL);
    }
}
