package com.jleber.login.challenge.repository;

import com.jleber.login.challenge.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserInfo, String> {

    Optional<UserInfo> findByEmailAndPassword(String email, String password);
    Optional<UserInfo> findByToken(String token);
}
