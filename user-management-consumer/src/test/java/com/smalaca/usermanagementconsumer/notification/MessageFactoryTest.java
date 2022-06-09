package com.smalaca.usermanagementconsumer.notification;

import com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer.UserDto;
import com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer.UserManagementProducer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class MessageFactoryTest {
    private static final String GROUP = "Avengers";

    private final UserManagementProducer producer = mock(UserManagementProducer.class);
    private final MessageFactory factory = new MessageFactory(producer);

    @Test
    void shouldCreateMessagesForExistingGroup() {
        given(producer.findAllForGroup(GROUP)).willReturn(Arrays.asList(
                new UserDto("Captain America", UUID.randomUUID().toString(), GROUP),
                new UserDto("Tony Stark", UUID.randomUUID().toString(), GROUP),
                new UserDto("Odinson", UUID.randomUUID().toString(), GROUP)
        ));

        List<Message> actual = factory.createFor(GROUP);

        assertThat(actual).containsExactlyInAnyOrder(
                Message.to("Captain America").body("Hello!"),
                Message.to("Tony Stark").body("Hello!"),
                Message.to("Odinson").body("Hello!")
        );
    }

    @Test
    void shouldCreateNoMessagesForNotExistingGroup() {
        given(producer.findAllForGroup(GROUP)).willReturn(emptyList());

        List<Message> actual = factory.createFor(GROUP);

        assertThat(actual).isEmpty();
    }
}
