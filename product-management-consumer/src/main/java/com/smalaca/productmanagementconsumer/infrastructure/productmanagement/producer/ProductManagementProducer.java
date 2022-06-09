package com.smalaca.productmanagementconsumer.infrastructure.productmanagement.producer;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class ProductManagementProducer {
    private final RestTemplate restTemplate;
    private final String url;

    ProductManagementProducer(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    Optional<Long> create(ProductDto productDto) {
        try {
            ProductDto response = restTemplate.postForObject(url, productDto, ProductDto.class);
            return Optional.of(response.getId());
        } catch (HttpClientErrorException exception) {
            return Optional.empty();
        }
    }

    public List<ProductDto> findAllForShopId(Long shopId) {
        try {
            ProductDto[] products = restTemplate.getForObject(url + "?shopId=" + shopId, ProductDto[].class);
            return asList(products);
        } catch (HttpClientErrorException exception) {
            return emptyList();
        }
    }

    void delete(Long id) {
        restTemplate.delete(url + "/" + id);
    }
}
