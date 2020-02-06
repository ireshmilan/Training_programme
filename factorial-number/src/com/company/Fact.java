package com.company;

public class Fact {

    static int factorial(int no) {
        int i;
        int facto =1;
        for (i = 1; i <= no; i++) {
            facto = facto * i;
        }

        return facto;
    }

    public static void main(String[] args) {
        // write your code here
        int number = 5;
        int fact;

        fact = factorial(number);
        System.out.println(fact);

    }
}
