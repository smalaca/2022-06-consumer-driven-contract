package com.smalaca.productmanagement.api.rest.shop;

import com.smalaca.productmanagement.persistence.product.ProductRepository;
import com.smalaca.productmanagement.persistence.shop.ShopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shop")
public class ShopRestController {
    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;

    ShopRestController(ShopRepository shopRepository, ProductRepository productRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("summary/{id}")
    public ResponseEntity<String> summary(@PathVariable Long id) {
        if (shopRepository.existsById(id)) {
            int amount = productRepository.countByShopId(id);
            return ResponseEntity.ok(foundMessage(id, amount));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String foundMessage(Long id, int amount) {
        if (amount == 0) {
            return "There is no products in the shop " + id + ".";
        } else {
            return "There are " + amount + " products in the shop " + id + ".";
        }
    }
}
