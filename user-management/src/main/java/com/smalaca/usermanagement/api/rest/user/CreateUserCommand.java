package com.smalaca.usermanagement.api.rest.user;

import lombok.Getter;

@Getter
public class CreateUserCommand {
    private String login;
    private String password;
    private String group;
}
