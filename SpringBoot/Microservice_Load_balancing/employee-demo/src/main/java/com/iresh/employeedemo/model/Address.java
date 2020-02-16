package com.iresh.employeedemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Address {
    //	IDENTITY Indicates that the persistence provider must assign primary keys for the entity using database identity column.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private String country;

}
