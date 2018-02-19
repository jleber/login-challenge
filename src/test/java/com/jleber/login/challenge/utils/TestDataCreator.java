package com.jleber.login.challenge.utils;

import com.jleber.login.challenge.dsl.CompanyDSL;
import com.jleber.login.challenge.dsl.ProductDSL;
import com.jleber.login.challenge.dsl.UserInfoDSL;
import com.jleber.login.challenge.model.Company;
import com.jleber.login.challenge.model.Product;
import com.jleber.login.challenge.model.UserInfo;

public class TestDataCreator {

    public static Product getProduct() {
        return ProductDSL.newProduct()
                .id(1L)
                .name("Mock Product")
                .type("Mock")
                .build();
    }

    public static Company getCompany(Product product) {
        return CompanyDSL.newCompany()
                .id(1L)
                .name("Mock")
                .address("Rua dos Mocks")
                .addressNumber("7A")
                .phone("11 555555555")
                .additionalInfo("none")
                .withProduct(product)
                .build();
    }

    public static UserInfo getUserInfo(Company company){

        return UserInfoDSL.newUser()
                .email("mock@mock.com")
                .name("Mock")
                .password("secret")
                .withToken()
                .withCompany(company)
                .build();
    }
}
