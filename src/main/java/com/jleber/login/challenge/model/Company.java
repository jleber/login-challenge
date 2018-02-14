package com.jleber.login.challenge.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "company")
public class Company {

    @Column(name = "id_company")
    private Long idCompany;

    private String name;
    private String phone;
    private String address;

    @Column(name = "address_number")
    private String addressNumber;

    @Column(name = "additional_info")
    private String additionalInfo;
}
