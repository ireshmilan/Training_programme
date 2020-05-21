package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        CareTaker careTaker=new CareTaker();
        Cafe cafe=new Cafe();

        cafe.addFood(new Foods("Devilled Chicken Pizza"));
        cafe.addFood(new Foods("Lava Cake"));

        careTaker.save(cafe);
        System.out.println(cafe);

        cafe.addFood(new Foods("Coke"));

        careTaker.save(cafe);
        System.out.println(cafe);

        cafe.addFood(new Foods("Chicken Bacon Pizza"));

        careTaker.save(cafe);
        System.out.println(cafe);

        cafe.addFood(new Foods("Hot & Spicy Chicken Pizza"));

        careTaker.save(cafe);
        System.out.println(cafe);

        cafe.addFood(new Foods("Double Chicken & Cheese Fiesta Pizza"));

        careTaker.save(cafe);
        System.out.println(cafe);

        careTaker.previous(cafe);
        System.out.println(cafe);

        careTaker.previous(cafe);
        System.out.println(cafe);

        cafe.addFood(new Foods("Pepsi"));

       // careTaker.save(cafe);
        System.out.println(cafe);

        careTaker.previous(cafe);
        System.out.println(cafe);


    }
}
