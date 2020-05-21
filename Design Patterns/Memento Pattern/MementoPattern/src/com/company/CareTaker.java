package com.company;

import java.util.Stack;

public class CareTaker {

    Stack<Cafe.CafeMemento> cafeHistory=new Stack<>();

    public void save(Cafe cafe){
        cafeHistory.push(cafe.save());
    }
    public void previous(Cafe cafe){
        if(!cafeHistory.empty()){
         cafe.previousFood(cafeHistory.pop());
        }else
            System.out.println("Can't get Previous Food");

    }
}
