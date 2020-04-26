package com.example.customerownerservice.model;

import com.example.customerownerservice.service.UserServiceImpl;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final CustomerOwner user = UserServiceImpl.user;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public CustomerOwner getUser() {
        return user;
    }
}