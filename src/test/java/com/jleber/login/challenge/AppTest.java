package com.jleber.login.challenge;

import com.jleber.login.challenge.controller.CompanyControllerTest;
import com.jleber.login.challenge.controller.UserControllerTest;
import com.jleber.login.challenge.model.Company;
import com.jleber.login.challenge.model.Product;
import com.jleber.login.challenge.utils.TestDataCreator;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import redis.embedded.RedisServer;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserControllerTest.class,
        CompanyControllerTest.class
})
public class AppTest {
    @Before
    public void setup() throws Exception {
        RedisServer redisServer = new RedisServer(6379);
        redisServer.start();
    }

}
