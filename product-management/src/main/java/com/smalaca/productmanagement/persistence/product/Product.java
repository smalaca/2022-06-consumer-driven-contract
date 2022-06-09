package com.smalaca.productmanagement.persistence.product;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Locale;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String index;
    private String description;
    private BigDecimal price;
    private Long shopId;

    public Product(String name, String index, String description, BigDecimal price, long shopId) {
        this.name = name;
        this.index = index;
        this.description = description;
        this.price = price;
        this.shopId = shopId;
    }

    public static Product create(String name, String description, BigDecimal price, long shopId) {
        String index = RandomStringUtils.random(6, true, true).toUpperCase(Locale.ROOT);
        return new Product(name, index, description, price, shopId);
    }

    public ProductDto asDto() {
        return new ProductDto(id, name, index, description, price, shopId);
    }
}
