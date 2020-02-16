package com.example.alocationservice.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer empId;
    private String start;
    private String end;
    private String name;

}
