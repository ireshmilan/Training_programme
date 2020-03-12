package com.iresh.rentservice.controller;

import com.iresh.rentservice.model.Rent;
import com.iresh.rentservice.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
public class RentController {

    @Autowired
    RentService rentService;

    @PostMapping("/save")
    public Rent save(@RequestBody Rent rent){
        return rentService.save(rent);
    }

    @GetMapping("/rent/{id}")
    public List<Rent> getAllRentById(@PathVariable("id") Integer customerId){
        return rentService.findById(customerId);
    }

}
