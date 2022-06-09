package com.smalaca.productmanagement.persistence.product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    int countByShopId(Long shopId);

    boolean existsByNameAndShopId(String name, Long shopId);

    List<Product> findAllByShopId(Long shopId);
}
