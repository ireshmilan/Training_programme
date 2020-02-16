package com.iresh.employeedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class EmployeeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDemoApplication.class, args);

    }

}
