package com.smalaca.usermanagement.persistence.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    boolean existsByLoginAndGroupName(String login, String groupName);

    List<User> findAllByGroupName(String groupName);
}
