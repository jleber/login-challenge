package com.jleber.login.challenge.dsl;

import com.jleber.login.challenge.model.Company;
import com.jleber.login.challenge.model.UserInfo;

import static org.springframework.util.DigestUtils.md5DigestAsHex;

public class UserInfoDSL {


    private UserInfo userInfo;

    private UserInfoDSL(){
        userInfo = new UserInfo();
    }

    public static UserInfoDSL newUser(){
        return new UserInfoDSL();
    }

    public UserInfoDSL email(String email){
        userInfo.setEmail(email);
        return this;
    }

    public UserInfoDSL name(String name){
        userInfo.setName(name);
        return this;
    }

    public UserInfoDSL password(String password){
        userInfo.setPassword(md5DigestAsHex(password.getBytes()));
        return this;
    }

    public UserInfoDSL withToken(){
        String token = userInfo.getEmail() + "API_USER_" + userInfo.getPassword();
        userInfo.setToken(md5DigestAsHex(token.getBytes()));
        return this;
    }

    public UserInfoDSL withCompany(Company company){
        userInfo.setCompany(company);
        return this;
    }

    public UserInfo build(){
        return userInfo;
    }
}
