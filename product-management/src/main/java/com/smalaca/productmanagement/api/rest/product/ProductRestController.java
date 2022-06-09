package com.smalaca.productmanagement.api.rest.product;

import com.smalaca.productmanagement.persistence.product.Product;
import com.smalaca.productmanagement.persistence.product.ProductDto;
import com.smalaca.productmanagement.persistence.product.ProductRepository;
import com.smalaca.productmanagement.persistence.shop.ShopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("products")
public class ProductRestController {
    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;

    ProductRestController(ProductRepository productRepository, ShopRepository shopRepository) {
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody CreateProductCommand command) {
        if (shopRepository.existsById(command.getShopId())) {
            if (productRepository.existsByNameAndShopId(command.getName(), command.getShopId())) {
                return ResponseEntity.status(CONFLICT).build();
            } else {
                Product product = Product.create(command.getName(), command.getDescription(), command.getPrice(), command.getShopId());
                ProductDto dto = productRepository.save(product).asDto();
                return ResponseEntity.status(CREATED).body(dto);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll(@RequestParam Long shopId) {
        if (shopRepository.existsById(shopId)) {
            List<ProductDto> products = productRepository.findAllByShopId(shopId).stream()
                    .map(Product::asDto)
                    .collect(toList());
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productRepository.findById(id).get().asDto();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
