package com.example.alocationservice.controller;

import com.example.alocationservice.model.Allocation;
import com.example.alocationservice.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class AllocationController {

    @Autowired
    AllocationService allocationService;


    @RequestMapping(value = "/allocation", method = RequestMethod.POST)
    public Allocation save(@RequestBody Allocation allocation) {

        return allocationService.save(allocation);
    }

    @RequestMapping(value = "/allocation", method = RequestMethod.GET)
    public List<Allocation> findAll() {
        return allocationService.fetchAllAllocations();
    }

    @RequestMapping(value = "allocation/findByEmployeeId/{id}", method = RequestMethod.GET)
    public List<Allocation> getAllocationByEmployeeId(@PathVariable Integer id) {
        System.out.println("+++++++++++++++++++2");
        return allocationService.getAllocationByEmployeeId(id);
    }
}
