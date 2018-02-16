package com.jleber.login.challenge.filter;

import com.jleber.login.challenge.model.UserInfo;
import com.jleber.login.challenge.service.UserInfoService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TokenAuthenticationFilter extends GenericFilterBean {

    private UserInfoService userInfoService;

    public TokenAuthenticationFilter(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;

        String token = httpRequest.getHeader("api_token");

        UserInfo userInfo = userInfoService.findByToken(token)
                                        .orElseThrow(() -> new RuntimeException("Invalid Token !"));

        UserDetails user = User.withUsername(userInfo.getEmail())
                                .password(userInfo.getPassword())
                                .credentialsExpired(false)
                                .accountExpired(false)
                                .accountLocked(false)
                                .disabled(false)
                                .authorities("API_USER")
                                .build();

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }
}
