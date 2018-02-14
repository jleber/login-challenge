package com.jleber.login.challenge.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyResponse {
    private String name;
    private String phone;
    private String address;
    private String addressNumber;
    private String additionalInfo;
}
