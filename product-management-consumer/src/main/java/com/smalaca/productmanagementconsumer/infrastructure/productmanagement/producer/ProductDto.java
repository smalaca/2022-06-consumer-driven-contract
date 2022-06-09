package com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

import static lombok.AccessLevel.PACKAGE;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = PACKAGE)
@ToString
@EqualsAndHashCode
public class ProductDto {
    private Long id;
    private String name;
    private String index;
    private String description;
    private BigDecimal price;
    private Long shopId;

    ProductDto(String name, String description, BigDecimal price, Long shopId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.shopId = shopId;
    }
}
