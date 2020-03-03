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

    @OneToOne(cascade = CascadeType.ALL)
    private VehicleBrand vehicleBrand;

    @OneToOne(cascade = CascadeType.ALL)
    private VehicleModel vehicleModel;

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    List<Damage> damage;

    public List<Damage> getDamage() {
        return damage;
    }

    public void setDamage(List<Damage> damage) {
        this.damage = damage;
    }
}
