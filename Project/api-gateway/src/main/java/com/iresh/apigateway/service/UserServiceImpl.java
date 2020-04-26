package com.iresh.apigateway.service;


import com.iresh.apigateway.model.CustomerOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl {

    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    public CustomerOwner saveInUserService(CustomerOwner customerOwner,String token){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Bearer "+token);
        HttpEntity<CustomerOwner> request = new HttpEntity<>(customerOwner,httpHeaders);
        ResponseEntity<CustomerOwner> response = restTemplate.exchange("http://localhost:6699/user/service/save", HttpMethod.POST, request, CustomerOwner.class);
        return response.getBody();
    }
}
