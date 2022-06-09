package com.smalaca.productmanagement.persistence.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

import static lombok.AccessLevel.PACKAGE;

@Getter
@RequiredArgsConstructor(access = PACKAGE)
public class ProductDto {
    private final Long id;
    private final String name;
    private final String index;
    private final String description;
    private final BigDecimal price;
    private final Long shopId;
}
