package com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class UserManagementProducer {
    private final RestTemplate restTemplate;
    private final String url;

    UserManagementProducer(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    Optional<Long> create(UserDto userDto) {
        try {
            UserDto response = restTemplate.postForObject(url + "/users", userDto, UserDto.class);
            return Optional.of(response.getId());
        } catch (HttpClientErrorException exception) {
            return Optional.empty();
        }
    }

    public List<UserDto> findAllForGroup(String groupName) {
        UserDto[] users = restTemplate.getForObject(url + "/users?group=" + groupName, UserDto[].class);

        return asList(users);
    }

    void delete(Long id) {
        restTemplate.delete(url + "/users/" + id);
    }

    String hello() {
        return restTemplate.getForObject(url + "/start", String.class);
    }

    String hello(String userName) {
        return restTemplate.getForObject(url + "/start/" + userName, String.class);
    }
}
