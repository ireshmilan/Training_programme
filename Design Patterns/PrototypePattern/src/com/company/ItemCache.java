package com.company;

import java.util.HashMap;

public class ItemCache {
    private static HashMap<String,Item> items= new HashMap<String, Item>();

    public static Item getItem(String id) throws CloneNotSupportedException {
        Item cashedItem = items.get(id);
        return (Item) cashedItem.clone();
    }

    public static void initialize(){
        Laptop laptop=new Laptop();
        laptop.setId("1");
        items.put(laptop.getId(),laptop);

        Pen pen= new Pen();
        pen.setId("2");
        items.put(pen.getId(),pen);


    }
}
