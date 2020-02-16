package com.example.alocationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class AlocationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlocationServiceApplication.class, args);
    }

}
