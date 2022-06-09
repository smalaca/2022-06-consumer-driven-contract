package com.smalaca.productmanagementconsumer.domain.product;

import com.google.common.collect.ImmutableList;
import com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer.ProductDto;
import com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer.ProductManagementProducer;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ProductServiceTest {
    private static final Long SHOP_ID = 42L;

    private final ProductManagementProducer producer = mock(ProductManagementProducer.class);
    private final ProductService service = new ProductService(producer);

    @Test
    void shouldHasAvailableProducts() {
        given(producer.findAllForShopId(SHOP_ID)).willReturn(ImmutableList.of(
                new ProductDto("Water", "Something to drink", BigDecimal.valueOf(123.45), SHOP_ID),
                new ProductDto("Tea", "Good for breakfast", BigDecimal.valueOf(13.42), SHOP_ID),
                new ProductDto("Coffee", "The best drink ever", BigDecimal.valueOf(321.12), SHOP_ID)
        ));

        AvailableProducts actual = service.availableProductsFor(SHOP_ID);

        assertThat(actual.getShopId()).isEqualTo(SHOP_ID);
        assertThat(actual.getProducts())
                .hasSize(3)
                .hasEntrySatisfying("Water", price -> assertThat(price).isEqualTo(BigDecimal.valueOf(123.45)))
                .hasEntrySatisfying("Tea", price -> assertThat(price).isEqualTo(BigDecimal.valueOf(13.42)))
                .hasEntrySatisfying("Coffee", price -> assertThat(price).isEqualTo(BigDecimal.valueOf(321.12)));
    }

    @Test
    void shouldNotHaveAvailableProducts() {
        given(producer.findAllForShopId(SHOP_ID)).willReturn(emptyList());

        AvailableProducts actual = service.availableProductsFor(SHOP_ID);

        assertThat(actual.getShopId()).isEqualTo(SHOP_ID);
        assertThat(actual.getProducts()).isEmpty();
    }
}