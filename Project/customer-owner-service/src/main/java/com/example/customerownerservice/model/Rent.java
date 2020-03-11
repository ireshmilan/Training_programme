package com.example.customerownerservice.model;

import lombok.Data;

@Data
public class Rent {
    private Integer id;
    private String needDate;
    private String endDate;
    private String start;
    private String end;
    private String comments;
    private Integer customerId;
    private Integer carId;

    private CustomerOwner customerOwner;
}
