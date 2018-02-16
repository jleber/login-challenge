package com.jleber.login.challenge.repository;

import com.jleber.login.challenge.model.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    Optional<Company> findCompanyByUsersInfoToken(String token);
}
