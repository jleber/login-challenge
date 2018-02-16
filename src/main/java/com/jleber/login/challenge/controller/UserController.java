package com.jleber.login.challenge.controller;

import com.jleber.login.challenge.request.UserRequest;
import com.jleber.login.challenge.response.UserResponse;
import com.jleber.login.challenge.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping(value = "/authenticate", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> authenticate(@RequestBody UserRequest userRequest) {
        UserResponse response = userInfoService.authenticate(userRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
