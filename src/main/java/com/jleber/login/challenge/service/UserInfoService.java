package com.jleber.login.challenge.service;

import com.jleber.login.challenge.model.UserInfo;
import com.jleber.login.challenge.repository.UserRepository;
import com.jleber.login.challenge.request.UserRequest;
import com.jleber.login.challenge.response.UserResponse;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserInfoService {

    private UserRepository repository;
    private MapperFacade mapper;

    public UserInfoService(@Autowired UserRepository userRepository, @Autowired MapperFacade mapperFacade) {
        repository = userRepository;
        mapper = mapperFacade;
    }

    public UserResponse authenticate(UserRequest userRequest){
        UserInfo user = repository.findByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword())
                                .orElseThrow(() -> new RuntimeException("Email or Password invalid !"));

        return mapper.map(user, UserResponse.class);
    }

    public Optional<UserInfo> findByToken(String token){
        if(StringUtils.isEmpty(token)){
            throw new RuntimeException("Request Without Token Header !");
        }

        return repository.findByToken(token);
    }
}
