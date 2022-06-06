package com.smalaca.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer")
public class ProducerRestController {
    @GetMapping
    public String hello() {
        return "Hello producer!";
    }
}
