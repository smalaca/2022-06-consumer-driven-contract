package com.smalaca.usermanagementconsumer.notification;

import com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer.UserDto;
import com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer.UserManagementProducer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageFactory {
    private final UserManagementProducer producer;

    public MessageFactory(UserManagementProducer producer) {
        this.producer = producer;
    }

    public List<Message> createFor(String group) {
        List<UserDto> existing = producer.findAllForGroup(group);

        return existing.stream()
                .map(dto -> Message.to(dto.getLogin()).body("Hello!"))
                .collect(Collectors.toList());
    }
}
