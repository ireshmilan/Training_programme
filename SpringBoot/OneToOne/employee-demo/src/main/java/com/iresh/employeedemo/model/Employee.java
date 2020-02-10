package com.iresh.employeedemo.model;

import javax.persistence.*;

@Entity
public class Employee {

//	IDENTITY Indicates that the persistence provider must assign primary keys for the entity using database identity column.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
