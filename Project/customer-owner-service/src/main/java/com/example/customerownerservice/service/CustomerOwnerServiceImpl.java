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
import java.util.Optional;

@Service
public class CustomerOwnerServiceImpl implements CustomerOwnerService{

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
    public CustomerOwner findByUsername(String username) {
        return customerOwnerRepository.findByUsername(username);
    }

    @Override
    public CustomerOwner findByEmail(String email) {
        return customerOwnerRepository.findByEmail(email);
    }

    @Override
    public CustomerOwner findByIdCardNumber(String idCardNumber) {
        return customerOwnerRepository.findByIdCardNumber(idCardNumber);
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
    public CustomerOwner findById(Integer id) {
        Optional<CustomerOwner> customerOwnerServiceOptional = customerOwnerRepository.findById(id);
        if (customerOwnerServiceOptional.isPresent())
            return customerOwnerServiceOptional.get();
        return null;
    }

    @Override
    public List<Rent> fetchAllRent(Integer customerId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<Rent[]> responseEntity = restTemplate.exchange("http://localhost:8686/service/rent/" + customerId,
                HttpMethod.GET, httpEntity, Rent[].class);

        Rent[] resultBody = responseEntity.getBody();
        List<Rent> rents = new ArrayList<>();

        for (Rent rent : resultBody) {
            rent.setCustomerOwner(this.findById(rent.getCustomerId()));
            rents.add(rent);
        }
        return rents;
    }

    @Override
    public CustomerOwner update(CustomerOwner customerOwner) {
        if(customerOwner.getId()!=0){
            for(Telephone telephone:customerOwner.getTelephone())
                telephone.setCustomerOwner(customerOwner);
        }
      customerOwner.setDlt(true);
        return customerOwnerRepository.save(customerOwner);
    }



    @Override
    public boolean findByActivity(boolean activity) {
        return customerOwnerRepository.findByActivity(activity==true);
    }
}
