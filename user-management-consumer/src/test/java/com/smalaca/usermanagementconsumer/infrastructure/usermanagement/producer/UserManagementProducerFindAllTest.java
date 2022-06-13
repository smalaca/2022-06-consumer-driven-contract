package com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserManagementProducerFindAllTest {
    private final UserManagementProducer producer = new UserManagementProducerFactory().userManagementProducer();
    private final UserManagementProducerContract contract = UserManagementProducerContract.create();

    @Test
    void shouldReturnUsersForGivenGroup() {
        UserManagementProducerScenario scenario = contract.usersFound();

        List<UserDto> actual = producer.findAllForGroup(scenario.getRequest());

        assertThat(actual).isEqualTo(scenario.getResponse());
    }

    @Test
    void shouldReturnNoUserForNotExistingGroup() {
        UserManagementProducerScenario scenario = contract.usersNotFoundForNotExistingGroup();

        List<UserDto> actual = producer.findAllForGroup(scenario.getRequest());

        assertThat(actual).isEqualTo(scenario.getResponse());
    }
}