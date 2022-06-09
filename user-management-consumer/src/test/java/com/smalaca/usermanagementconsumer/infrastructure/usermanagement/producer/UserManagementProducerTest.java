package com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UserManagementProducerTest {
    private static final String GROUP = "Spider Verse";
    private final UserManagementProducer producer = new UserManagementProducerFactory().userManagementProducer();

    @BeforeEach
    void removeAllFromGroup() {
        producer.findAllForGroup(GROUP).forEach(dto -> {
            producer.delete(dto.getId());
        });
    }

    @Test
    void shouldCreateUser() {
        Optional<Long> actual = producer.create(new UserDto("gwenstacy", UUID.randomUUID().toString(), GROUP));

        assertThat(actual)
                .isPresent()
                .containsInstanceOf(Long.class);
    }

    @Test
    void shouldNotCreateUserWhenItAlreadyExists() {
        producer.create(new UserDto("maryjane", UUID.randomUUID().toString(), GROUP));

        Optional<Long> actual = producer.create(new UserDto("maryjane", UUID.randomUUID().toString(), GROUP));

        assertThat(actual).isEmpty();
    }

    @Test
    void shouldReturnUsersForGivenGroup() {
        List<UserDto> actual = producer.findAllForGroup("Avengers");

        assertThat(actual)
                .hasSize(3)
                .anySatisfy(dto -> assertThat(dto).isEqualTo(new UserDto(1L, "Captain America", UUID.randomUUID().toString(), "Avengers")))
                .anySatisfy(dto -> assertThat(dto).isEqualTo(new UserDto(2L, "Tony Stark", UUID.randomUUID().toString(), "Avengers")))
                .anySatisfy(dto -> assertThat(dto).isEqualTo(new UserDto(3L, "Odinson", UUID.randomUUID().toString(), "Avengers")));
    }

    @Test
    void shouldReturnNoUserForNotExistingGroup() {
        List<UserDto> actual = producer.findAllForGroup("Defenders");

        assertThat(actual).isEmpty();
    }
}