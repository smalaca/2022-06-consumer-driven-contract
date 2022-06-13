package com.smalaca.usermanagement.api.rest.start;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("start")
public class StartRestController {
//    /start/sebastian
//        200
//        Hello sebastian!
//    /start
//        200
//        Hello guest!
    @GetMapping(value = {"", "/{user}"})
    public String start(@PathVariable Optional<String> user) {
        if (user.isPresent()) {
            return "Hello " + user.get() + "!";
        } else {
            return "Hello guest!";
        }
    }
}
