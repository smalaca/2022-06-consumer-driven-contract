package com.smalaca.productmanagement.configuration.listener.shop;

import com.smalaca.productmanagement.persistence.shop.Shop;
import com.smalaca.productmanagement.persistence.shop.ShopRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ShopsFactory {
    private final ShopRepository repository;

    ShopsFactory(ShopRepository repository) {
        this.repository = repository;
    }

    @EventListener
    public void listen(ContextRefreshedEvent event) {
        repository.save(new Shop(13L, "Lucky Number"));
        repository.save(new Shop(42L, "Answer for everything"));
    }
}
