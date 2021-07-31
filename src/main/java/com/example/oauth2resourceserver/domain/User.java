package com.example.oauth2resourceserver.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @Column
    private String uid;

    @Column
    private String name;

    @Column
    private String email;
}
