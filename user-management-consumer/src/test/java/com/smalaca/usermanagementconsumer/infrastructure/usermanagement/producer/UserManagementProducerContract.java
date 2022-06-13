package com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class UserManagementProducerContract {
    private static final String USERS_FOUND = "USERS_FOUND";
    private static final String NOT_EXISTING_GROUP = "NOT_EXISTING_GROUP";
    private final Map<String, UserManagementProducerScenario> scenarios;

    private UserManagementProducerContract(Map<String, UserManagementProducerScenario> scenarios) {
        this.scenarios = scenarios;
    }

    public static UserManagementProducerContract create() {
        return new UserManagementProducerContract(ImmutableMap.of(
                USERS_FOUND, new UserManagementProducerScenario("Avengers", Arrays.asList(
                        new UserDto(1L, "Captain America", UUID.randomUUID().toString(), "Avengers"),
                        new UserDto(2L, "Tony Stark", UUID.randomUUID().toString(), "Avengers"),
                        new UserDto(3L, "Odinson", UUID.randomUUID().toString(), "Avengers")
                )),
                NOT_EXISTING_GROUP, new UserManagementProducerScenario("Defenders", Collections.emptyList())
        ));
    }

    public UserManagementProducerScenario usersFound() {
        return scenarios.get(USERS_FOUND);
    }

    public UserManagementProducerScenario usersNotFoundForNotExistingGroup() {
        return scenarios.get(NOT_EXISTING_GROUP);
    }
}
