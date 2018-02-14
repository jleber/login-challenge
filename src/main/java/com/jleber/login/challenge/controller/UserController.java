package com.jleber.login.challenge.controller;

import com.jleber.login.challenge.request.UserRequest;
import com.jleber.login.challenge.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping("/users")
public class UserController {

    @PostMapping(value = "/authentication", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> registration(UserRequest userRequest) {
        return null;
    }
}
