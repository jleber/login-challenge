package com.jleber.login.challenge.controller;

import com.jleber.login.challenge.response.CompanyResponse;
import com.jleber.login.challenge.response.ProductResponse;
import com.jleber.login.challenge.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<CompanyResponse> findCompany(HttpServletRequest request){
        CompanyResponse response = companyService.findCompany(request.getHeader("api_token"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{idCompany}/products")
    public ResponseEntity<List<ProductResponse>> findCompanyProducts(@PathVariable("idCompany") Long idCompany){
        List<ProductResponse> response = companyService.findCompanyProducts(idCompany);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
