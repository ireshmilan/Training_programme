package com.iresh.rentservice.controller;

import com.iresh.rentservice.model.Rent;
import com.iresh.rentservice.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "*")
public class RentController {

    @Autowired
    RentService rentService;

    @PostMapping("/save")
    public Rent save(@RequestBody Rent rent){
        return rentService.save(rent);
    }

//  //  find all rent datails
//    @GetMapping("/getAllRent")
//    public List<Rent> findAllRent(@RequestHeader(name = "Authorization")String token){
//        return rentService.getAllRent(token);
 //   }
    @GetMapping("/getAllRent")
    public List<Rent> findAll(){
        return rentService.findAll();
    }

    @GetMapping("/getAllPreviousRents")
    public List<Rent> findAllPrevious(){
        return rentService.findAllPrevious();
    }

    @GetMapping("/findAllRents/{id}")
    public  List<Rent> findAllCRentById(@PathVariable("id") Integer id){
        return rentService.getAllRent(id);
    }


    //find by customer id
    @GetMapping("/rent/{id}")
    public List<Rent> getAllRentById(@PathVariable("id") Integer customerId){
        System.out.println("customerId"+customerId);
        return rentService.findById(customerId);
    }

    @GetMapping("/previousRent/{id}")
    public List<Rent> getAllPreviousRentById(@PathVariable("id") Integer customerId){
        return rentService.previousRentFindById(customerId);
    }

    @PutMapping("/update")
    public Rent update (@RequestBody Rent rent){
        return rentService.update(rent);
    }

    @PutMapping("/cancel")
    public Rent cancel (@RequestBody Rent rent){
        return rentService.cancel(rent);
    }

    @PutMapping("/complete")
    public Rent complete (@RequestBody Rent rent){
        return rentService.complete(rent);
    }
}
