package com.company;

public class Pen extends Item {

    public Pen(){
        type="pen";
        price=2500.00;
        warranty="6 Month";
    }

    @Override
    void addItem() {
        System.out.println("added pen");
    }
}
