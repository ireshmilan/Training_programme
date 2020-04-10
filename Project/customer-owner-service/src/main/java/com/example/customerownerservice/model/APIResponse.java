package com.example.customerownerservice.model;

import lombok.Data;

@Data
public class APIResponse {

    private int status;
    private String message;
    private String parameter;


    public APIResponse() {
    }

    public APIResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public APIResponse(int status, String message, String parameter) {
        this.status = status;
        this.message = message;
        this.parameter = parameter;
    }


}