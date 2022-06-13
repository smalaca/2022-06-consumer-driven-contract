package com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer;

import lombok.Getter;

import java.util.List;

@Getter
public class UserManagementProducerScenario {
    private final String request;
    private final List<UserDto> response;

    UserManagementProducerScenario(String request, List<UserDto> response) {
        this.request = request;
        this.response = response;
    }
}
