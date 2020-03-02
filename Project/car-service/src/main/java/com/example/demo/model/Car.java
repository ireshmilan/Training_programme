package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Car {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String registeredNumber;
    private String registerdYear;

    @OneToOne(cascade = CascadeType.ALL)
    private VehicleBrand vehicleBrand;

    @OneToOne(cascade = CascadeType.ALL)
    private VehicleModel vehicleModel;

}
