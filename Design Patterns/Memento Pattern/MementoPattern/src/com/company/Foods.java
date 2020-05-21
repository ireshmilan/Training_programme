package com.company;

public class Foods {
    public String foodName;

    public Foods(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "foodName='" + foodName + '\'' +
                '}';
    }
}
