package com.iresh.rentservice.controller;

import com.iresh.rentservice.model.Rent;
import com.iresh.rentservice.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service")
public class RentController {

    @Autowired
    RentService rentService;

    @PostMapping("/save")
    public Rent save(@RequestBody Rent rent){
        return rentService.save(rent);
    }

}
