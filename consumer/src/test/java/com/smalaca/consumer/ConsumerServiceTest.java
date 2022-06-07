package com.smalaca.consumer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureStubRunner(
        ids = {"com.smalaca:producer:+:stubs:8014"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ConsumerServiceTest {
    @Autowired private ConsumerService service;

    private static Stream<Arguments> values() {
        return Stream.of(
                Arguments.of("no", "expected"),
                Arguments.of("another", "expected"),
                Arguments.of("hello", "expected"),
                Arguments.of("dasdsad", "expected")
        );
    }

    @ParameterizedTest
    @MethodSource("values")
    void foo(String param, String expected) {
        String actual = service.hello(param);

        assertThat(actual).isEqualTo(expected);
    }
}