package com.smalaca.productmanagement.persistence.shop;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Shop {
    @Id
    private Long id;
    private String name;

    public Shop(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
