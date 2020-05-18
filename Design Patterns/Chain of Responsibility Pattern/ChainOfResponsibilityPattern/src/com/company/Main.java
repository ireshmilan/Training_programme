package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Silver silver=new Silver();
        Gold gold= new Gold();
        Platinum platinum= new Platinum();
        Discount discount= new Discount();

        discount.setSuccoser(silver);
        silver.setSuccoser(gold);
        gold.setSuccoser(platinum);

        Invoice invoice=new Invoice(1,890);
        System.out.println(discount.applyDiscount(invoice));

        Invoice invoice1 =new Invoice(2,56000);
        System.out.println(discount.applyDiscount(invoice1));

        Invoice invoice3=new Invoice(3,12000);
        System.out.println(discount.applyDiscount(invoice3));
    }
}
