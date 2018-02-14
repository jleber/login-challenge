package com.jleber.login.challenge.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class User {

    private String email;
    private String name;
    private String password;
    private String token;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_company", nullable=false)
    private Company company;
}
