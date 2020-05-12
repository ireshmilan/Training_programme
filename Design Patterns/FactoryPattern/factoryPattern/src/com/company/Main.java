package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DiscountFactory discountFactory=new DiscountFactory();

        System.out.println("Enter Item: ");
        Scanner scanner=new Scanner(System.in);
        String itemName=scanner.next();
        System.out.println("Enter Price");
        Double price=scanner.nextDouble();

        Discount discount=discountFactory.getDiscount(itemName);

        System.out.println("Item name: "+itemName+ " Price: "+price );
        discount.getRate();
        discount.calculateBill(price);



    }
}
