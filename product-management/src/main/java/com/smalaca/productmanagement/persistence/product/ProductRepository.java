package com.smalaca.productmanagement.persistence.product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    int countByShopId(Long shopId);
}
