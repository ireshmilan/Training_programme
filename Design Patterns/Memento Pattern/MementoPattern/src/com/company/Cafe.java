package com.company;

import java.util.ArrayList;

public class Cafe {

    ArrayList<Foods> foods = new ArrayList<>();

    public void addFood(Foods foods1){
        foods.add(foods1);

    }

    public ArrayList<Foods> getFoods() {
        return (ArrayList<Foods>) foods.clone();
    }

    public CafeMemento save(){
        return new CafeMemento(getFoods());
    }

    public void previousFood(CafeMemento cafeMemento){

        foods=cafeMemento.getFoods();
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "foods=" + foods +
                '}';
    }

    static class CafeMemento{
        ArrayList<Foods> foods;

        public CafeMemento(ArrayList<Foods> foods) {
            this.foods = foods;
        }

//getter method is private because only outer class can access it
        private ArrayList<Foods> getFoods() {
            return foods;
        }
    }
}
