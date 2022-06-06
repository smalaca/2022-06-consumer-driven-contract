package com.smalaca.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class ConsumerRestController {
    @GetMapping
    public String hello() {
        return "Hello consumer!";
    }
}
