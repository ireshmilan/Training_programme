package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Car {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String registeredNumber;
    private String registerdYear;
    private String fuleType;
    private String transmission;
    private String vehicleBrand;
    private Integer ownerId;

    @OneToOne(cascade = CascadeType.ALL)
    private VehicleModel vehicleModel;

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    List<Damage> damage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegisteredNumber() {
        return registeredNumber;
    }

    public void setRegisteredNumber(String registeredNumber) {
        this.registeredNumber = registeredNumber;
    }

    public String getRegisterdYear() {
        return registerdYear;
    }

    public void setRegisterdYear(String registerdYear) {
        this.registerdYear = registerdYear;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public List<Damage> getDamage() {
        return damage;
    }

    public void setDamage(List<Damage> damage) {
        this.damage = damage;
    }

    public String getFuleType() {
        return fuleType;
    }

    public void setFuleType(String fuleType) {
        this.fuleType = fuleType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}
