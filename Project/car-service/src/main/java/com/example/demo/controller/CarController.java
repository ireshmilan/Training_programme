package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/save")
    public Car save(@RequestParam("photo") MultipartFile multipartFile, @RequestParam("car") String car) throws IOException {
        Car updatedCar = new ObjectMapper().readValue(car, Car.class);

        updatedCar.setPhoto(multipartFile.getBytes());
        System.out.println("aaaaaaaaaaa"+updatedCar);
        return carService.save(updatedCar);
    }

//    @PostMapping("/save")
//    public Car save(@RequestBody Car car){
//        System.out.println(car);
//        return carService.save(car);
//    }

    @PutMapping("/update")
    public Car update(@RequestBody Car car){
        return carService.update(car);
    }

    @PutMapping("/delete")
    public Car delete(@RequestBody Car car){
        return carService.delete(car);
    }

    @GetMapping("/findAllCars")
    public List<Car> findAllCar(){
        return carService.getAllCar();
    }
//this one use for rent
    @GetMapping("/findAllCarsId/{id}")
    public  List<Car> findAllCarsById(@PathVariable("id") Integer id){
        System.out.println("id   "+id);
        return carService.getAllCars(id);
}
//this one us for tables
    @GetMapping("/findAllCars/{id}")
    public  List<Car> findAllCarsByNo(@PathVariable("id") Integer id){
        return carService.getAllCars(id);
    }

    @GetMapping("/findAllOwners/{id}")
    public List<Car> findAllOwners(@PathVariable("id") Integer id){
        return carService.fetchAllOwners(id);
    }



}
