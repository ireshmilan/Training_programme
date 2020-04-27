package com.iresh.rentservice.service;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.iresh.rentservice.model.Car;
import com.iresh.rentservice.model.CustomerOwner;
import com.iresh.rentservice.model.Rent;
import com.iresh.rentservice.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository rentRepository;

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Rent save(Rent rent) {
        rent.setActive(true);
        rent.setComplete(false);
        rent.setStatus("Processing");
        rent.setCreatedDate(LocalDate.now());
        return rentRepository.save(rent);
    }

    @Override
    public Rent update(Rent rent) {
        rent.setActive(true);
        rent.setComplete(false);
        rent.setStatus("Processing");
        rentRepository.save(rent);
        return rent;
    }


    @Override
    public Rent cancel(Rent rent) {
        rent.setActive(false);
        rent.setComplete(false);
        rent.setStatus("Cancel");
        rentRepository.save(rent);
        return rent;
    }

    @Override
    public Rent complete(Rent rent) {
        rent.setActive(false);
        rent.setComplete(true);
        rent.setStatus("Completed");
        rentRepository.save(rent);
        return rent;
    }

    @Override
    public List<Rent> findById(Integer id) {

        List<Rent> rents = new ArrayList<>();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

        for (Rent rent : rentRepository.findByCustomerId(id)) {
            System.out.println("rent   "+rent);
            ResponseEntity<Car[]> responseEntity = restTemplate.exchange("http://localhost:9923/service/findAllCarsId/" + rent.getCarId(), HttpMethod.GET, httpEntity, Car[].class);
            rent.setCar(responseEntity.getBody());

            rents.add(rent);
        }
        return rents;


    }

    @Override
    public List<Rent> previousRentFindById(Integer id) {
        List<Rent> rents = new ArrayList<>();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

        for (Rent rent : rentRepository.findByCustomerIda(id)) {
            System.out.println("rent   "+rent);
            ResponseEntity<Car[]> responseEntity = restTemplate.exchange("http://localhost:9923/service/findAllCarsId/" + rent.getCarId(), HttpMethod.GET, httpEntity, Car[].class);
            rent.setCar(responseEntity.getBody());

            rents.add(rent);
        }
        return rents;
    }


    //    @Override
//    public List<Rent> getAllRent(String token) {
//        System.out.println("lollllllllllllllllllllllll" + token);
//        List<Rent> rents = new ArrayList<>();
//        HttpHeaders httpHeaders = new HttpHeaders();
////        httpHeaders.add("Content-Type", "application/json");
////        httpHeaders.add("Authorization", token);
//        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
//        for (Rent rent : rentRepository.findAll()) {
////            ResponseEntity<CustomerOwner> customer=restTemplate.exchange("http://localhost:7676/service/get/"+rent.getCustomerId(),
////                    HttpMethod.GET,httpEntity, CustomerOwner.class);
////            rent.setCustomerOwner(customer.getBody());
//            ResponseEntity<Car> car = restTemplate.exchange("http://localhost:9923/service/findAllCars/" + rent.getCarId(),
//                    HttpMethod.GET, httpEntity, Car.class);
//            rent.setCar(car.getBody());
//            rents.add(rent);
//        }
//        return rents;
//    }


    @Override
    public List<Rent> findAll() {


            List<Rent> rents = new ArrayList<>();
            HttpHeaders httpHeaders = new HttpHeaders();
            HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

            for (Rent rent : rentRepository.findAll()) {
                System.out.println("rent   "+rent);
                ResponseEntity<Car[]> responseEntity = restTemplate.exchange("http://localhost:9923/service/findAllCarsId/" + rent.getCarId(), HttpMethod.GET, httpEntity, Car[].class);
                rent.setCar(responseEntity.getBody());
                ResponseEntity<CustomerOwner[]> responseEntity1=restTemplate.exchange("http://localhost:7676/service/get/"+rent.getCustomerId(), HttpMethod.GET,httpEntity, CustomerOwner[].class);
                rent.setCustomerOwner(responseEntity1.getBody());
                rents.add(rent);
            }
            return rents;

        }


    @Override
    public List<Rent> getAllRent(Integer id) {
        List<Rent> rents = new ArrayList<>();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

        for (Rent rent : rentRepository.findAllById(id)) {
            System.out.println("rent   "+rent);
            ResponseEntity<Car[]> responseEntity = restTemplate.exchange("http://localhost:9923/service/findAllCarsId/" + rent.getCarId(), HttpMethod.GET, httpEntity, Car[].class);
            rent.setCar(responseEntity.getBody());
            ResponseEntity<CustomerOwner[]> responseEntity1=restTemplate.exchange("http://localhost:7676/service/get/"+rent.getCustomerId(), HttpMethod.GET,httpEntity, CustomerOwner[].class);
            rent.setCustomerOwner(responseEntity1.getBody());
            rents.add(rent);
        }
        return rents;
    }

    @Override
    public List<Rent> findAllPrevious() {


        List<Rent> rents = new ArrayList<>();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);

        for (Rent rent : rentRepository.findAllPrevios()) {
            System.out.println("rent   "+rent);
            ResponseEntity<Car[]> responseEntity = restTemplate.exchange("http://localhost:9923/service/findAllCarsId/" + rent.getCarId(), HttpMethod.GET, httpEntity, Car[].class);
            rent.setCar(responseEntity.getBody());
            ResponseEntity<CustomerOwner[]> responseEntity1=restTemplate.exchange("http://localhost:7676/service/get/"+rent.getCustomerId(), HttpMethod.GET,httpEntity, CustomerOwner[].class);
            rent.setCustomerOwner(responseEntity1.getBody());
            rents.add(rent);
        }
        return rents;

    }
}



