package com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureStubRunner(
        ids = {"com.smalaca:product-management:+:stubs:8200"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ProductManagementProducerCreateProductTest {
    @Autowired private ProductManagementProducer producer;

    @Test
    void shouldCreateProduct() {
        Optional<Long> actual = producer.create(new ProductDto("Water", "SomethingToDrink", BigDecimal.valueOf(123.45), 42L));

        assertThat(actual)
                .isPresent()
                .containsInstanceOf(Long.class);
    }

    @Test
    void shouldNotCreateProductWhenItAlreadyExists() {
        Optional<Long> actual = producer.create(new ProductDto("Coffee", "SomethingToDrink", BigDecimal.valueOf(123.45), 13L));

        assertThat(actual).isEmpty();
    }

    @Test
    void shouldNotCreateProductWhenShopDoesNotExist() {
        Optional<Long> actual = producer.create(new ProductDto("Coffee", "SomethingToDrink", BigDecimal.valueOf(123.45), 7L));

        assertThat(actual).isEmpty();
    }
}