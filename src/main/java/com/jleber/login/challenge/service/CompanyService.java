package com.jleber.login.challenge.service;

import com.jleber.login.challenge.repository.CompanyRepository;
import com.jleber.login.challenge.response.CompanyResponse;
import com.jleber.login.challenge.response.ProductResponse;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository repository;
    private MapperFacade mapper;

    public CompanyService(@Autowired CompanyRepository repository, @Autowired MapperFacade mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Cacheable(cacheNames = {"findCompany"},key = "#root.method.name + #token")
    public CompanyResponse findCompany(String token){
        return repository.findCompanyByUsersInfoToken(token)
                .map(company -> mapper.map(company, CompanyResponse.class))
                .orElseGet(CompanyResponse::new);
    }

    @Cacheable(cacheNames = {"findCompanyProducts"},key = "#root.method.name + #idCompany")
    public List<ProductResponse> findCompanyProducts(Long idCompany){
        return mapper.mapAsList(repository.findOne(idCompany).getProducts(), ProductResponse.class);
    }
}
