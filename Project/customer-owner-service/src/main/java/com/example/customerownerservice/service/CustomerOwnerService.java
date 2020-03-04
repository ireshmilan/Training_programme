package com.example.customerownerservice.service;

import com.example.customerownerservice.model.CustomerOwner;

import java.util.List;

public interface CustomerOwnerService {
    CustomerOwner save(CustomerOwner customerOwner);
    List<CustomerOwner> getAllCustomerOwner();
}
