package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.model.CustomerOwner;

import java.util.List;

public interface CarService  {
    Car save(Car car);
    List<Car> getAllCar();
    Car getCarById(Integer id);
    List<Car> fetchAllOwners(Integer ownerId);
    Car update(Car car);
    Car delete(Car car);
    List<Car> getAllCars(Integer id);



}
