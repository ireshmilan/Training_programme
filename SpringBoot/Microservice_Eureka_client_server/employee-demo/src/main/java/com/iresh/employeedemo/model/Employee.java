package com.iresh.employeedemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Employee {

    //	IDENTITY Indicates that the persistence provider must assign primary keys for the entity using database identity column.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private Allocation[] allocations;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Telephone> telephones;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(joinColumns = @JoinColumn(name = "eid",referencedColumnName = "id"),
            inverseJoinColumns = {@JoinColumn(name = "pid",referencedColumnName = "id")})
    List<Project> projects;

    public Employee(){

    }
}
