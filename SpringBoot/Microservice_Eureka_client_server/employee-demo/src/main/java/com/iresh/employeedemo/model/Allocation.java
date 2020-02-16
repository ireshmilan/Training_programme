package com.iresh.employeedemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Allocation {
    private Integer id;
    private String start;
    private String end;
    private String name;
@JsonIgnore
    private Integer empId;
    private Employee employee;


}
