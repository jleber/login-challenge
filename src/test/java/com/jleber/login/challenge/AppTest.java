package com.jleber.login.challenge;

import com.jleber.login.challenge.controller.CompanyControllerTest;
import com.jleber.login.challenge.controller.UserControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserControllerTest.class,
        CompanyControllerTest.class
})
public class AppTest {


}
