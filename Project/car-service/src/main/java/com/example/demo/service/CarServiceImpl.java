package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public Car save(Car car) {

        Car dbCar = carRepository.findByRegisteredNumber(car.getRegisteredNumber());
        if(dbCar==null) {
            car.setAvailability(Boolean.TRUE);
            car.setHide(Boolean.TRUE);
            car.setCreatedDate(LocalDate.now());
           return carRepository.save(car);
        }

        return null;
    }


    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Integer id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent())
            return car.get();
        return null;
    }

    @Override
    public List<Car> fetchAllOwners(Integer ownerId) {
        return carRepository.findByOwnerId(ownerId);
    }

    @Override
    public Car update(Car car) {
        car.setHide(Boolean.TRUE);
        return carRepository.save(car);
    }


    @Override
    public Car delete(Car car) {
        car.setHide(Boolean.FALSE);
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars(Integer id) {

        return carRepository.findAllById(id);
    }
}
