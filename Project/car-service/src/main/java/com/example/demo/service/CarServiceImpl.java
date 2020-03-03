package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.model.Damage;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public Car save(Car car) {
       for(Damage damage:car.getDamage())
           damage.setCar(car);
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }
}
