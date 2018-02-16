package com.jleber.login.challenge.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_company")
    private Long idCompany;

    private String name;
    private String phone;
    private String address;

    @Column(name = "address_number")
    private String addressNumber;

    @Column(name = "additional_info")
    private String additionalInfo;

    @OneToMany(mappedBy="company")
    private List<UserInfo> usersInfo;
}
