package com.jleber.login.challenge.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String token;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_company", nullable=false)
    private Company company;

}
