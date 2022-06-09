package com.smalaca.productmanagement.configuration.listener.product;

import com.smalaca.productmanagement.persistence.product.Product;
import com.smalaca.productmanagement.persistence.product.ProductRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductsFactory {
    private final ProductRepository repository;

    ProductsFactory(ProductRepository repository) {
        this.repository = repository;
    }

    @EventListener
    public void listen(ContextRefreshedEvent event) {
        repository.save(new Product("Water", "ABC123", "Something to drink", BigDecimal.valueOf(123.45), 13L));
        repository.save(new Product("Tea", "XYZ987", "Good for breakfast", BigDecimal.valueOf(13.42), 13L));
        repository.save(new Product("Coffee", "A1B2C3", "The best drink ever", BigDecimal.valueOf(321.12), 13L));
    }
}
