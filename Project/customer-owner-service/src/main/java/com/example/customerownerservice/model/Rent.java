package com.example.customerownerservice.model;

import java.time.LocalDate;

public class Rent {
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

    private CustomerOwner customerOwner;

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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CustomerOwner getCustomerOwner() {
        return customerOwner;
    }

    public void setCustomerOwner(CustomerOwner customerOwner) {
        this.customerOwner = customerOwner;
    }
}
