package com.example.customerownerservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CustomerOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String type;
    private String dateOfBirth;
    private String idCardNumber;


    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private Email email;

    @OneToMany(mappedBy = "customerOwner",cascade = CascadeType.ALL)
    List<Telephone>telephone;
}

