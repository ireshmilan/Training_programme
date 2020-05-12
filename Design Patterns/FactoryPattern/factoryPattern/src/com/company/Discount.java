package com.company;

public abstract class Discount {
    protected double discountRate;
    private Double totalBill;
    abstract void getRate();

    public void calculateBill(double price){
         totalBill=price-price*discountRate/100;
        System.out.println("Total Bill is: "+totalBill);
    }
}
