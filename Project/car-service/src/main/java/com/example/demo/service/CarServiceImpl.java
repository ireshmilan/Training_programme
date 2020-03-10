package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.model.CustomerOwner;
import com.example.demo.model.Damage;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
       for(Damage damage:car.getDamage())
           damage.setCar(car);
        return carRepository.save(car);
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
    public List<CustomerOwner> fetchAllOwners(Integer ownerId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity=new HttpEntity<>("",httpHeaders);

        ResponseEntity<CustomerOwner[]> result =restTemplate.exchange("http://localhost/service/get/"+ownerId,
                HttpMethod.GET,httpEntity,CustomerOwner[].class);

        CustomerOwner[] resultBody = result.getBody();
        List<CustomerOwner> customerOwners = new ArrayList<>();

        for (CustomerOwner customerOwner : resultBody) {
            customerOwner.setCar(this.getCarById(customerOwner.getId()));
            customerOwners.add(customerOwner);
        }
        return customerOwners;
    }
}
