package com.smalaca.productmanagement.api.rest.product;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateProductCommand {
    private String name;
    private String description;
    private BigDecimal price;
    private Long shopId;
}
