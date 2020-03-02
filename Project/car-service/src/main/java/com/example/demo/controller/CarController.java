package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
public class CarController {

    @Autowired
    CarService carService;
    @PostMapping("/save")
    public Car save(@RequestBody Car car){
        return carService.save(car);
    }

    @GetMapping("/findAllCars")
    public List<Car> findAllCar(){
        return carService.getAllCar();
    }

}
