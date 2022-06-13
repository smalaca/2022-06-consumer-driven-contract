package com.smalaca.usermanagementconsumer.notification;

import com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer.UserManagementProducer;
import com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer.UserManagementProducerContract;
import com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer.UserManagementProducerScenario;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class MessageFactoryTest {
    private final UserManagementProducer producer = mock(UserManagementProducer.class);
    private final UserManagementProducerContract contract = UserManagementProducerContract.create();
    private final MessageFactory factory = new MessageFactory(producer);

    @Test
    void shouldCreateMessagesForExistingGroup() {
        UserManagementProducerScenario scenario = contract.usersFound();
        given(producer.findAllForGroup(scenario.getRequest())).willReturn(scenario.getResponse());

        List<Message> actual = factory.createFor(scenario.getRequest());

        assertThat(actual).containsExactlyInAnyOrder(
                Message.to("Captain America").body("Hello!"),
                Message.to("Tony Stark").body("Hello!"),
                Message.to("Odinson").body("Hello!")
        );
    }

    @Test
    void shouldCreateNoMessagesForNotExistingGroup() {
        UserManagementProducerScenario scenario = contract.usersNotFoundForNotExistingGroup();
        given(producer.findAllForGroup(scenario.getRequest())).willReturn(scenario.getResponse());

        List<Message> actual = factory.createFor(scenario.getRequest());

        assertThat(actual).isEmpty();
    }
}
