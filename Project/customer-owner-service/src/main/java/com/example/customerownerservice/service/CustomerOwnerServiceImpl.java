package com.example.customerownerservice.service;

import com.example.customerownerservice.model.CustomerOwner;
import com.example.customerownerservice.model.Rent;
import com.example.customerownerservice.model.Telephone;
import com.example.customerownerservice.repository.CustomerOwnerRepository;
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

@Service
public class CustomerOwnerServiceImpl implements CustomerOwnerService {

    @Autowired
    CustomerOwnerRepository customerOwnerRepository;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public CustomerOwner save(CustomerOwner customerOwner) {
        for(Telephone telephone:customerOwner.getTelephone())
            telephone.setCustomerOwner(customerOwner);
        return customerOwnerRepository.save(customerOwner);
    }

    @Override
    public List<CustomerOwner> getAllCustomerOwner() {
        return customerOwnerRepository.findAll();
    }

    @Override
    public List<CustomerOwner> getAllCustomerOwnerById(Integer id) {

        return customerOwnerRepository.findAllById(id);
    }

    @Override
    public List<Rent> fetchAllRent(Integer rentId) {
        HttpHeaders httpHeaders=new HttpHeaders();
        HttpEntity<String> httpEntity=new HttpEntity<>( "",httpHeaders);
        ResponseEntity<Rent[]> responseEntity=restTemplate.exchange("http://localhost:8686/service/rent/"+rentId,
        HttpMethod.GET,httpEntity,Rent[].class);

        Rent[] resultBody = responseEntity.getBody();
        List<Rent> rents =new ArrayList<>();

        for(Rent rent : resultBody){
            rent.setCustomerOwner((CustomerOwner) this.getAllCustomerOwnerById(rent.getCustomerId()));
            rents.add(rent);
        }
        return rents;
    }


}
