package com.smalaca.productmanagementconsumer.domain.product;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Getter
class AvailableProducts {
    private final Long shopId;
    private final Map<String, BigDecimal> products = new HashMap<>();

    AvailableProducts(Long shopId) {
        this.shopId = shopId;
    }

    void add(String name, BigDecimal price) {
        products.put(name, price);
    }
}
