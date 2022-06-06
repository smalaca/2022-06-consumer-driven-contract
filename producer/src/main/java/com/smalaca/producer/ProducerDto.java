package com.smalaca.producer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class ProducerDto {
    static final ProducerDto NOT_EXISTING = new ProducerDto(UUID.randomUUID(), "NOT existing", -1);
    private final UUID id;
    private final String title;
    private final int producerId;
}
