package com.jleber.login.challenge.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    private Long idProduct;
    private String name;
    private String type;

}
