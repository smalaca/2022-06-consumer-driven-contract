package com.smalaca.usermanagement.persistence.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String login;
    private String password;
    private String groupName;

    public User(String login, String password, String groupName) {
        this.login = login;
        this.password = password;
        this.groupName = groupName;
    }

    public UserDto asDto() {
        return new UserDto(id, login, groupName);
    }
}
