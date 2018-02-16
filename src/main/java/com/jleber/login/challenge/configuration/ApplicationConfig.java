package com.jleber.login.challenge.configuration;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.jleber.login.challenge")
@EnableJpaRepositories(basePackages = "com.jleber.login.challenge.repository")
@EntityScan(basePackages = "com.jleber.login.challenge.model")
public class ApplicationConfig {

    @Bean
    public MapperFacade mapperFacade(){
        return new DefaultMapperFactory.Builder().build().getMapperFacade();
    }

}
