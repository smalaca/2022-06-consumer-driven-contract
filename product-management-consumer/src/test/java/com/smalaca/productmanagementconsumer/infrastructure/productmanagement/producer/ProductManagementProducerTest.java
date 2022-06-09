package com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ProductManagementProducerTest {
    private static final Long SHOP_ID = 42L;

    private final ProductManagementProducer producer = new ProductManagementProducerFactory().productManagementProducer();

    @BeforeEach
    void removeAllFromShop() {
        producer.findAllForShopId(SHOP_ID).forEach(dto -> {
            producer.delete(dto.getId());
        });
    }

    @Test
    void shouldCreateProduct() {
        Optional<Long> actual = producer.create(new ProductDto("Water", "Something to drink", BigDecimal.valueOf(123.45), SHOP_ID));

        assertThat(actual)
                .isPresent()
                .containsInstanceOf(Long.class);
    }

    @Test
    void shouldNotCreateProductWhenItAlreadyExists() {
        producer.create(new ProductDto("Coffee", "Something to drink", BigDecimal.valueOf(123.45), SHOP_ID));

        Optional<Long> actual = producer.create(new ProductDto("Coffee", "Something to drink", BigDecimal.valueOf(123.45), SHOP_ID));

        assertThat(actual).isEmpty();
    }

    @Test
    void shouldNotCreateProductWhenShopDoesNotExist() {
        producer.create(new ProductDto("Coffee", "Something to drink", BigDecimal.valueOf(123.45), SHOP_ID));

        Optional<Long> actual = producer.create(new ProductDto("Coffee", "Something to drink", BigDecimal.valueOf(123.45), SHOP_ID));

        assertThat(actual).isEmpty();
    }

    @Test
    void shouldReturnProductsForGivenShop() {
        List<ProductDto> actual = producer.findAllForShopId(13L);

        assertThat(actual)
                .hasSize(3)
                .anySatisfy(dto -> assertThat(dto).isEqualTo(new ProductDto(1L, "Water", "ABC123", "Something to drink", BigDecimal.valueOf(123.45), 13L)))
                .anySatisfy(dto -> assertThat(dto).isEqualTo(new ProductDto(2L, "Tea", "XYZ987", "Good for breakfast", BigDecimal.valueOf(13.42), 13L)))
                .anySatisfy(dto -> assertThat(dto).isEqualTo(new ProductDto(3L, "Coffee", "A1B2C3", "The best drink ever", BigDecimal.valueOf(321.12), 13L)));
    }

    @Test
    void shouldReturnNoProductForNotExistingShop() {
        List<ProductDto> actual = producer.findAllForShopId(7L);

        assertThat(actual).isEmpty();
    }
}