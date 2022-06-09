package com.smalaca.usermanagement.persistence.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByLoginAndGroupName(String login, String groupName);

    List<User> findAllByGroupName(String groupName);
}
