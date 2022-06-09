package com.smalaca.usermanagementconsumer.notification;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Message {
    private final String login;
    private final String body;

    private Message(String login, String body) {
        this.login = login;
        this.body = body;
    }

    static Builder to(String login) {
        return new Builder(login);
    }

    public static class Builder {
        private final String login;

        private Builder(String login) {
            this.login = login;
        }

        Message body(String body) {
            return new Message(login, body);
        }
    }
}
