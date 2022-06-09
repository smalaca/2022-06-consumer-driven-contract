package com.smalaca.usermanagement.persistence.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PACKAGE;

@Getter
@RequiredArgsConstructor(access = PACKAGE)
public class UserDto {
    private final Long id;
    private final String login;
    private final String group;
}
