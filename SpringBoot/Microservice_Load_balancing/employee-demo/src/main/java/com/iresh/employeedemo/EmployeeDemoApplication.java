package com.iresh.employeedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class EmployeeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDemoApplication.class, args);

    }
    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    HttpHeaders getHttpHeaders(){
        return new HttpHeaders();
    }

}
