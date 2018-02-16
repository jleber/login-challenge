package com.jleber.login.challenge.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.util.DigestUtils;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {
    private String email;
    private String password;
    private String token;

    public void setPassword(String password) {
        this.password = DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
