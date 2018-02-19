package com.jleber.login.challenge.dsl;


import com.jleber.login.challenge.model.Company;
import com.jleber.login.challenge.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CompanyDSL {

    private Company company;
    private List<Product> products;

    private CompanyDSL(){
        company = new Company();
        products = new ArrayList<>();
        company.setProducts(products);
    }

    public static CompanyDSL newCompany(){
        return new CompanyDSL();
    }

    public CompanyDSL id(Long id){
        company.setIdCompany(id);
        return this;
    }

    public CompanyDSL name(String name){
        company.setName(name);
        return this;
    }

    public CompanyDSL address(String address){
        company.setAddress(address);
        return this;
    }

    public CompanyDSL addressNumber(String number){
        company.setAddressNumber(number);
        return this;
    }

    public CompanyDSL additionalInfo(String additionalInfo){
        company.setAdditionalInfo(additionalInfo);
        return this;
    }

    public CompanyDSL phone(String phone){
        company.setPhone(phone);
        return this;
    }

    public CompanyDSL withProduct(Product product){
        company.getProducts().add(product);
        return this;
    }

    public CompanyDSL withProducts(List<Product> products){
        company.getProducts().addAll(products);
        return this;
    }

    public Company build(){
        return company;
    }
}
