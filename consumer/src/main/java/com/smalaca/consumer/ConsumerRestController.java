package com.smalaca.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class ConsumerRestController {
    private final ConsumerService consumerService;

    public ConsumerRestController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("{param}")
    public String hello(@PathVariable String param) {
        return consumerService.hello(param);
    }
}
