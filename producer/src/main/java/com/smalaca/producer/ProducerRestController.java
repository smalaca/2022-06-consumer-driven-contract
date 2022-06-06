package com.smalaca.producer;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("producer")
public class ProducerRestController {
    private final Map<String, ProducerDto> params = ImmutableMap.of(
            "hello", new ProducerDto(UUID.randomUUID(), "Hello world!", 1),
            "no", new ProducerDto(UUID.randomUUID(), "No world!", 1),
            "another", new ProducerDto(UUID.randomUUID(), "Another world!", 2)
    );

    @GetMapping("/{param}")
    public ProducerDto hello(@PathVariable String param) {
        return params.getOrDefault(param, ProducerDto.NOT_EXISTING);
    }
}
