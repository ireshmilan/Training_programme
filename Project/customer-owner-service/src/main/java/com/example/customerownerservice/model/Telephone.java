package com.example.customerownerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String telephone;

    @ManyToOne
            @JoinColumn
            @JsonIgnore
    CustomerOwner customerOwner;

    public CustomerOwner getCustomerOwner() {
        return customerOwner;
    }

    public void setCustomerOwner(CustomerOwner customerOwner) {
        this.customerOwner = customerOwner;
    }
}
