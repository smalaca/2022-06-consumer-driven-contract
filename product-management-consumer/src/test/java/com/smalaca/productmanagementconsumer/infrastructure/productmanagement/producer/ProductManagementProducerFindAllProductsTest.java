package com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductManagementProducerFindAllProductsTest {
    private final ProductManagementProducer producer = new ProductManagementProducerFactory().productManagementProducer();

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