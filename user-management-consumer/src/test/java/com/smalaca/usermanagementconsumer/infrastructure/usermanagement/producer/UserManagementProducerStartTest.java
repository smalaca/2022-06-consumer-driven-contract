package com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureStubRunner(
        ids = {"com.smalaca:user-management:+:stubs:8100"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class UserManagementProducerStartTest {
    @Autowired private UserManagementProducer producer;

    @Test
    void shouldSayHelloToGuest() {
        String actual = producer.hello();

        assertThat(actual).isEqualTo("Hello guest!");
    }

    @Test
    void shouldSayHello() {
        String actual = producer.hello("Sebastian");

        assertThat(actual).isEqualTo("Hello Sebastian!");
    }
}