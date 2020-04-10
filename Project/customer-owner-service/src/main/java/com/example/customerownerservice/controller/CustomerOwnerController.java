package com.example.customerownerservice.controller;

import com.example.customerownerservice.model.CustomerOwner;
import com.example.customerownerservice.model.Rent;
import com.example.customerownerservice.service.CustomerOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("service")
public class CustomerOwnerController {

    @Autowired
    CustomerOwnerService customerOwnerService;

//    @PostMapping("/save")
//    public CustomerOwner save(@RequestBody CustomerOwner customerOwner) {
//        return customerOwnerService.save(customerOwner);
//    }
    @PutMapping("/update")
    public CustomerOwner update(@RequestBody CustomerOwner customerOwner){
        return customerOwnerService.update(customerOwner);
    }

//    @GetMapping("/get")
//    public List<CustomerOwner> findAllCustomerOwner() {
//        return customerOwnerService.getAllCustomerOwner();
//    }

    @GetMapping("/get/{id}")
    public List<CustomerOwner> findAllById(@PathVariable("id") Integer carId){

        return customerOwnerService.getAllCustomerOwnerById(carId);
    }



  //customer rents
    @GetMapping("/getRent/{empId}")
    public List<Rent> fetchAllRent(@PathVariable Integer empId){
        return customerOwnerService.fetchAllRent(empId);
    }
}
