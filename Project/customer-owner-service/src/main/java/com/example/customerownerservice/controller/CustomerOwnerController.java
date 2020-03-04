package com.example.customerownerservice.controller;

import com.example.customerownerservice.model.CustomerOwner;
import com.example.customerownerservice.service.CustomerOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
public class CustomerOwnerController {

    @Autowired
    CustomerOwnerService customerOwnerService;

    @PostMapping("/save")
    public CustomerOwner save(@RequestBody CustomerOwner customerOwner) {
        return customerOwnerService.save(customerOwner);
    }

    @GetMapping("/get")
    public List<CustomerOwner> findAllCustomerOwner() {
        return customerOwnerService.getAllCustomerOwner();
    }
}
