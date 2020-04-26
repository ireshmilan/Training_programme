package com.iresh.rentservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String needDate;
    private String endDate;
    private String start;
    private String end;
    private String comments;
    private LocalDate createdDate;
    private Integer customerId;
    private Integer carId;
    private boolean active;
    private boolean complete;
    private String status;
    @Transient
    private CustomerOwner[] customerOwner;
    @Transient
    private Car[] car;


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNeedDate() {
        return needDate;
    }

    public void setNeedDate(String needDate) {
        this.needDate = needDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Car[] getCar() {
        return car;
    }

    public void setCar(Car[] car) {
        this.car = car;
    }

    public CustomerOwner[] getCustomerOwner() {
        return customerOwner;
    }

    public void setCustomerOwner(CustomerOwner[] customerOwner) {
        this.customerOwner = customerOwner;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
