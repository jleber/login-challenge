package com.jleber.login.challenge.service;

import com.jleber.login.challenge.repository.CompanyRepository;
import com.jleber.login.challenge.response.CompanyResponse;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private CompanyRepository repository;
    private MapperFacade mapper;

    public CompanyService(@Autowired CompanyRepository repository, @Autowired MapperFacade mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public CompanyResponse findCompany(String token){
        return repository.findCompanyByUsersInfoToken(token)
                    .map(company -> mapper.map(company, CompanyResponse.class))
                    .orElseGet(() -> new CompanyResponse());
    }
}
