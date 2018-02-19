package com.jleber.login.challenge.configuration;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.jleber.login.challenge")
@EnableJpaRepositories(basePackages = "com.jleber.login.challenge.repository")
@EntityScan(basePackages = "com.jleber.login.challenge.model")
@EnableCaching
public class ApplicationTestConfig {

    @Bean
    public MapperFacade mapperFacade() {
        return new DefaultMapperFactory.Builder().build().getMapperFacade();
    }

    @Bean
    CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("findCompanyProducts","userToken","findCompany");
    }


}
