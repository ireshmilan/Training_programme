package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
@Table(name="cars")
public class Car {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String registeredNumber;
    private String registerdYear;
    private String fuleType;
    private String transmission;
    private String vehicleBrand;
    private String acOrNonAc;
    private String comment;


    private LocalDate createdDate;
    private boolean availability;
    private boolean hide;
    private String ownerId;
    @Lob
    private byte[] photo;

    @OneToOne(cascade = CascadeType.ALL)
    private VehicleModel vehicleModel;




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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAcOrNonAc() {
        return acOrNonAc;
    }

    public void setAcOrNonAc(String acOrNonAc) {
        this.acOrNonAc = acOrNonAc;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }
}
