package com.company;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        ItemCache.initialize();

        Item item=ItemCache.getItem("1");
        System.out.println("Item : " + item.getType()+" Price "+ item.getPrice()+ "Warranty : "+item.getWarranty());

        item.setType("Mini");

        System.out.println("Item : " + item.getType()+" Price "+ item.getPrice()+ "Warranty : "+item.getWarranty());

        Item item1=ItemCache.getItem("2");
        System.out.println("Item : " + item1.getType()+ " price "+ item.getPrice());


    }
}
