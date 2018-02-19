package com.jleber.login.challenge;

import com.jleber.login.challenge.controller.CompanyControllerTest;
import com.jleber.login.challenge.controller.UserControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserControllerTest.class,
        CompanyControllerTest.class
})
public class AppTest {

    @Primary
    @Bean
    CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("sample");
    }

}
