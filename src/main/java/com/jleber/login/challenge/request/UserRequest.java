package com.jleber.login.challenge.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {
    private String email;
    private String password;
    private String token;
}
