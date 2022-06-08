package com.smalaca.usermanagement.persistence.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;

@Getter
@RequiredArgsConstructor(access = PACKAGE)
public class UserDto {
    private final UUID id;
    private final String login;
    private final String group;
}
