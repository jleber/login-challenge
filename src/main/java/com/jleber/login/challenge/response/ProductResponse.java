package com.jleber.login.challenge.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
    private Long idProduct;
    private String name;
    private String type;
}
