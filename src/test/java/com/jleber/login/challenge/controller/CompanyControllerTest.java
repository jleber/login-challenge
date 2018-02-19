package com.jleber.login.challenge.controller;

import com.jleber.login.challenge.configuration.ApplicationTestConfig;
import com.jleber.login.challenge.model.Company;
import com.jleber.login.challenge.model.Product;
import com.jleber.login.challenge.repository.CompanyRepository;
import com.jleber.login.challenge.repository.ProductRepository;
import com.jleber.login.challenge.repository.UserRepository;
import com.jleber.login.challenge.utils.TestDataCreator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = ApplicationTestConfig.class)
public class CompanyControllerTest {


    @Autowired
    private MockMvc mockMvc;

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

    @Test
    public void shouldCompanyRequestReturnInfo() throws Exception {

        String token = userRepository.findOne("mock@mock.com").getToken();

        mockMvc.perform(get("/companies")
                .header("api_token", token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test(expected = RuntimeException.class)
    public void shouldRequestWithoutTokenFail() throws Exception {
        mockMvc.perform(get("/companies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void shouldProductRequestReturnInfo() throws Exception {

        Long idCompany = companyRepository.findOne(1L).getIdCompany();
        String token = userRepository.findOne("mock@mock.com").getToken();

        mockMvc.perform(get("/companies/"+idCompany+"/products")
                .header("api_token", token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
