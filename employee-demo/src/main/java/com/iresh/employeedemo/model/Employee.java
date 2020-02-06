package com.iresh.employeedemo.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int marks;

    public Employee(String name, int marks) {
        this.name=name;
        this.marks=marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public static List<Employee> getAllEmployees(){
        List<Employee> employeeList =new ArrayList<>();
        employeeList.add(new Employee("Iresh",88));
        employeeList.add(new Employee("Kasun",79));
        employeeList.add(new Employee("Yogeesh",99));
        return employeeList;
    }
}
