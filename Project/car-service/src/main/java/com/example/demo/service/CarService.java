package com.example.demo.service;

import com.example.demo.model.Car;

import java.util.List;

public interface CarService  {
    Car save(Car car);
    List<Car> getAllCar();
}
