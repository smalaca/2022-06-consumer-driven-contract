package com.smalaca.productmanagementconsumer.domain.product;

import com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer.ProductDto;
import com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer.ProductManagementProducer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ProductService {
    private final ProductManagementProducer producer;

    ProductService(ProductManagementProducer producer) {
        this.producer = producer;
    }

    AvailableProducts availableProductsFor(Long shopId) {
        List<ProductDto> products = producer.findAllForShopId(shopId);
        AvailableProducts availableProducts = new AvailableProducts(shopId);
        products.forEach(dto -> availableProducts.add(dto.getName(), dto.getPrice()));

        return availableProducts;
    }
}
