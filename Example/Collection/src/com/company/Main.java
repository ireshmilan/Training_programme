package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Iresh",80));
        employees.add(new Employee("Abishek",90));
        employees.add(new Employee("Kasun",70));
        employees.add(new Employee("Mahanama",50));
        employees.add(new Employee("Mithila",100));

        Comparator<Employee> employeeComparator = (e1,e2) -> (e1.getMark()>e2.getMark()?+1 : (e1.getMark()<e2.getMark())?-1:0);
        Collections.sort(employees,employeeComparator);
        System.out.println(employees);

    }
}
