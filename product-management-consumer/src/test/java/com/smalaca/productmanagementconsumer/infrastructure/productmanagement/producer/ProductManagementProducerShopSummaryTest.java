package com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ProductManagementProducerShopSummaryTest {
    private final ProductManagementProducer producer = new ProductManagementProducerFactory().productManagementProducer();

    @BeforeEach
    void removeAllFromShop() {
        producer.findAllForShopId(42L).forEach(dto -> {
            producer.delete(dto.getId());
        });
    }

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