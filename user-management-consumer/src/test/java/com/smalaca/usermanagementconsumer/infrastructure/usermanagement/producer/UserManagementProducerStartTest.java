package com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserManagementProducerStartTest {
    private final UserManagementProducer producer = new UserManagementProducerFactory().userManagementProducer();

    @Test
    void shouldSayHelloToGuest() {
        String actual = producer.hello();

        assertThat(actual).isEqualTo("Hello guest!");
    }

    @Test
    void shouldSayHello() {
        String actual = producer.hello("steve");

        assertThat(actual).isEqualTo("Hello steve!");
    }
}