package com.smalaca.usermanagement.configuration.listener.user;

import com.smalaca.usermanagement.persistence.user.User;
import com.smalaca.usermanagement.persistence.user.UserRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsersFactory {
    private final UserRepository repository;

    public UsersFactory(UserRepository repository) {
        this.repository = repository;
    }

    @EventListener
    public void createUsers(ContextRefreshedEvent event) {
        repository.save(new User("Captain America", UUID.randomUUID().toString(), "Avengers"));
        repository.save(new User("Tony Stark", UUID.randomUUID().toString(), "Avengers"));
        repository.save(new User("Odinson", UUID.randomUUID().toString(), "Avengers"));
        repository.save(new User("Jean Grey", UUID.randomUUID().toString(), "X-Men"));
        repository.save(new User("Ororo", UUID.randomUUID().toString(), "X-Men"));
    }
}
