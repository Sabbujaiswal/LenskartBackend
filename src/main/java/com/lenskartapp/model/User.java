package com.lenskartapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class User {

    @Id
    @Column(length = 20, name = "userid")
    @GeneratedValue(generator = "user_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", initialValue = 1, allocationSize = 1)
    private Integer userId;
    @Column(length = 20)
    private String userName;
    @Column(length = 20)
    private String password;
    @Column(length = 20)
    private  String mobile;
    @Column(length = 20)
    private String email;
    @Column(length = 20)
    private String address;
    @Column(length = 20)
    private  Integer zipcode;


    public User(String userName, String password, String mobile, String email, String address, Integer zipcode) {
        this.userName = userName;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.zipcode = zipcode;
    }

    public User() {
    }
}
