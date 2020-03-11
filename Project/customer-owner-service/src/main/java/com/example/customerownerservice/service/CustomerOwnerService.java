package com.example.customerownerservice.service;

import com.example.customerownerservice.model.CustomerOwner;
import com.example.customerownerservice.model.Rent;

import java.util.List;

public interface CustomerOwnerService {
    CustomerOwner save(CustomerOwner customerOwner);
    List<CustomerOwner> getAllCustomerOwner();
    List<CustomerOwner> getAllCustomerOwnerById(Integer id);
    List<Rent> fetchAllRent(Integer empId);
}
