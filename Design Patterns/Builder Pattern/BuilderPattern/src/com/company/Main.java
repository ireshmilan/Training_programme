package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
	// write your code here

        Item.Builder builder = new Item.Builder(1,"fan");
        Item item=builder.price(9000.00).mfd(new SimpleDateFormat("dd/MM/yyyy").parse("10/10/2020")).build();
        System.out.println(item);
    }
}
