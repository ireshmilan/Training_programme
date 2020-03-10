package com.example.demo.model;

import lombok.Data;

@Data
public class CustomerOwner {

    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String type;
    private String dateOfBirth;
    private String idCardNumber;

private Car car;
}
