package com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureStubRunner(
        ids = {"com.smalaca:product-management:+:stubs:8200"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ProductManagementProducerShopSummaryTest {
    @Autowired private ProductManagementProducer producer;

    @Test
    void shouldSummarizeShopWithProducts() {
        Optional<String> actual = producer.summary(13L);

        assertThat(actual)
                .isPresent()
                .contains("There are 3 products in the shop 13.");
    }

    @Test
    void shouldSummarizeShopWithoutProducts() {
        Optional<String> actual = producer.summary(42L);

        assertThat(actual)
                .isPresent()
                .contains("There is no products in the shop 42.");
    }

    @Test
    void shouldSummarizeNotExistingShop() {
        Optional<String> actual = producer.summary(7L);

        assertThat(actual).isEmpty();
    }
}