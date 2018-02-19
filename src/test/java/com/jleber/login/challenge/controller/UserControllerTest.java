package com.jleber.login.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = ApplicationTestConfig.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setup() throws Exception {
        objectMapper = new ObjectMapper();
        Product product = productRepository.save(TestDataCreator.getProduct());
        Company company = companyRepository.save(TestDataCreator.getCompany(product));
        userRepository.save(TestDataCreator.getUserInfo(company));
    }

    @Test
    public void shouldUserAuthenticate() throws Exception {
        ObjectNode request = objectMapper.createObjectNode()
                                         .put("email", "mock@mock.com")
                                         .put("password", "secret");

        mockMvc.perform(post("/users/authenticate")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUserAuthenticationFail() throws Exception {
        ObjectNode request = objectMapper.createObjectNode()
                .put("email", "mock@mock2.com")
                .put("password", "secret2");

        mockMvc.perform(post("/users/authenticate")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
