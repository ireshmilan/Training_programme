package com.example.customerownerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerOwnerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerOwnerServiceApplication.class, args);
    }

}
