package com.smalaca.usermanagement.api.rest.user;

import com.smalaca.usermanagement.persistence.user.User;
import com.smalaca.usermanagement.persistence.user.UserDto;
import com.smalaca.usermanagement.persistence.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("users")
public class UserRestController {
    private final UserRepository repository;

    public UserRestController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody CreateUserCommand command) {
        if (repository.existsByLoginAndGroupName(command.getLogin(), command.getGroup())) {
            return ResponseEntity.status(CONFLICT).build();
        } else {
            User user = new User(command.getLogin(), command.getPassword(), command.getGroup());
            UserDto dto = repository.save(user).asDto();
            return ResponseEntity.status(CREATED).body(dto);
        }
    }

    @GetMapping
    public List<UserDto> findAll(@RequestParam String group) {
        return repository.findAllByGroupName(group).stream()
                .map(User::asDto)
                .collect(toList());
    }

    @GetMapping("{id}")
    public UserDto findById(@PathVariable Long id) {
        return repository.findById(id).get().asDto();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
