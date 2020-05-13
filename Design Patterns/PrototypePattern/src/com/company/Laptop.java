package com.company;

public class Laptop extends Item{

    public Laptop(){
        type="Laptop";
        price=99000.00;
        warranty="3 Years";
    }

    @Override
    void addItem() {
        System.out.println("added laptop");
    }
}
