package com.jleber.login.challenge;

import com.jleber.login.challenge.controller.CompanyControllerTest;
import com.jleber.login.challenge.controller.UserControllerTest;
import com.jleber.login.challenge.model.Company;
import com.jleber.login.challenge.model.Product;
import com.jleber.login.challenge.repository.CompanyRepository;
import com.jleber.login.challenge.repository.ProductRepository;
import com.jleber.login.challenge.repository.UserRepository;
import com.jleber.login.challenge.utils.TestDataCreator;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

@RunWith(Suite.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@Suite.SuiteClasses({
        UserControllerTest.class,
        CompanyControllerTest.class
})
public class AppTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setup() throws Exception {
        Product product = productRepository.save(TestDataCreator.getProduct());
        Company company = companyRepository.save(TestDataCreator.getCompany(product));
        userRepository.save(TestDataCreator.getUserInfo(company));
    }


}
